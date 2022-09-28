# Trainee simulator

## The team
 - Abdullah Abdullah
 - Andrei Cravtov
 - Daniils Beilins
 - Luca Cooper-Lindsay
 - Maddie McMurray
 - Syed Muhammad Ali Zahir

This program creates a simulation that runs for a specified number of month and during this time it will create training centres and trainee objects to populate these centres. While the simulation is running if the number of trainees in a centre falls below 25 or that centre doesn't reach 25 trainees after one month of being active that centre will be removed and all trainees will be transferred to a different training centre. When the simulation ends it will return various information pertaining to the state of the simulation when it ended.  

## Training Centre
There simulation has 3 types of training centres, all of which 
are subclasses of the abstract class `TrainingCentre`.
### Abstract class
```java
public abstract class TrainingCentre {
    private final int centerID;
    private final List<Trainee> trainees;

    private boolean open;

    public int getCenterID() { return centerID; }

    public List<Trainee> getTrainees() { return trainees; }

    public TrainingCentre(int centerID) {
        this.centerID = centerID;
        trainees = new ArrayList<>();
    }

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);
}
```
The abstract class has an `int CenterID` a `List<Trainee> trainees` 
and a `boolean open`. It also has 3 abstract boolean methods 
called `canBeClosed`, `canAdd`, and `addTrainee`.
### Bootcamp
```java
public class Bootcamp extends TrainingCentre {
    public Bootcamp(int centerID) {
        super(centerID);
    }

    @Override
    public boolean canBeClosed() {
        return false;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return false;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return false;
    }
}
```
The `Bootcamp` can hold up to 500 Trainees and is only closed 
if the number of trainees attending is below 25 for 3 consecutive
months. There can only be 2 bootcamps up at one time.

### Tech Centre
```java
public class TechCentre extends TrainingCentre {
    private final Course course;

    public Course getCourse() { return course; }

    public TechCentre(int centerID) {
        super(centerID);
        course = Course.getRandomCourse();
    }

    @Override
    public boolean canBeClosed() {
        if (trainees.size()<25) return true;
        else return false;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        // if full
        if (course != trainee.getCourse()) return false;
        if (trainees.size()==200) return false;
        else return true;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        else if (trainee.getCourse()!=course) return false;
        else return true;
    }
}
```
The `TechCentre` can hold up to 200 Trainees at a time but will only
teach a single course while the other can teach multiple courses.

### Training Hub
```java
public class TrainingHub extends TrainingCentre {
    public TrainingHub(int id, Timeable timeable) {
        super(id, timeable);
    }

    @Override
    public boolean canBeClosed() {
        return (timekeeper.getTime() - timeCreated) > GRACE_PERIOD &&
                trainees.size() < 25;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                trainees.size() < 100 &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        return trainees.add(trainee);
    }
}
```
The `TrainingHub` can hold up to 100 Trainees and each month a random 
amount, up to 3, can be opened.

## Trainee
```java
public class Trainee implements Comparable<Trainee> {

    static int idCount=0;

    private final int traineeId;
    private final Course course;

    static int createId(){

        idCount++;
        return idCount;
    }

    public static Trainee createTrainee(){

        Random rand = new Random();
        int x = createId();

        return new Trainee(x, Course.getRandomCourse()); // make this give random course
 //       Starter.logger.info("Trainee: "+ Trainee);
    }


    public int getId() { return traineeId; }

    public Course getCourse() { return course; }

    public Trainee(int traineeId, @NotNull Course course) {
        this.traineeId = traineeId;
        this.course = course;
    }

    /**
     * This method serializes the trainee object.
     * It turns the fields in the trainee object into a string.
     * @return the string representation of the trainee object
     */
    @Override
    public String toString() { return String.format("Trainee( ID: %s, Course name: %s )", traineeId, course.getName()); }

    /**
     * Indicates whether some Trainee is "equal to" this one.
     *
     * @param obj the reference Trainee with which to compare.
     * @return {@code true} if this object is the same as the obj argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final Trainee trainee = (Trainee) obj;
        return traineeId == trainee.getId() &&
                course == trainee.course;
    }

    /**
     * Returns a hash code value for this Trainee. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 821;
        hash = 53 * hash + traineeId;
        hash = 53 * hash + course.hashCode();
        return hash;
    }

    @Override
    public int compareTo(@NotNull Trainee o) {
        return (this.traineeId - o.traineeId);
    }
}

```
The `Trainee` class creates instances of the `Trainee` object 
that will be used to populate the centres. The class has two 
private fields, one is `int traineeId` and the other is an 
`emun course`. The class has a `static int createID` that is 
used to increment through IDs for trainee so no two trainees 
can have the same ID. The `createTrainee` method creates a 
new instance of trainee.

## Timeable
```java
public interface Timeable {
    public int getTime();
    public void tick();
    public boolean isGracePeriod();
    public void resetMonthCount();
}
```
The `Timeable` interface has the above methods.

### MonthTime
```java
public class MonthTime implements Timeable {

    private static int monthCounter = 0;
    private final int GRACE_PERIOD = 3;
    private static MonthTime theTimeInstance;

    public static MonthTime getMonthlyInstance() {
        if (theTimeInstance == null) {
            theTimeInstance = new MonthTime();
        }
        return theTimeInstance;
    }

    @Override
    public int getTime() {
        return currentMonth();
    }

    @Override
    public void tick() {
        incrementMonth();
    }

    @Override
    public boolean isGracePeriod() {
        if (monthCounter < GRACE_PERIOD) {
            return true;
        }
        return false;
    }

    @Override
    public void resetMonthCount() {
        monthCounter = 0;
    }

    public int currentMonth() {
        return monthCounter;
    }

    public int incrementMonth() {
        return monthCounter++;
    }
}
```
The `MonthTime` class is an implementation of the `Timeable` interface
and is responsible for various features pertaining to the passage
of time in the simulation. It has a `static int monthCounter` that
keeps track of how much time has passed. The `final int GRACE_PERIOD`
is there to prevent any centers from being closed in the first 3 months.

## WaitingList
```java
public interface WaitingList {

    public boolean addTrainee(Trainee trainee);

    /**
     * Returns the fist trainee in the waiting list.
     * @return the first trainee, if list not empty <br>
     * {@code null}, if list is empty
     */
    public Trainee getFirstInQueue();

    public BlockingQueue<Trainee> getWaitingList();

    public int sizeOfWaitingList();
}
```
The `WaitingList` interface has methods for getting the first 
person in a list, a method for getting the entire list and a 
method for getting the size of a list.

### New Trainee Waiting List
```java
public class NewTraineeWaitingList implements WaitingList {

    public BlockingQueue<Trainee> newTrainingWaitingList;
    private static NewTraineeWaitingList newTraineeInstance;

    private NewTraineeWaitingList() {
        this.newTrainingWaitingList = new LinkedBlockingQueue<>();
    }

    public static NewTraineeWaitingList getInstance() {
        if (newTraineeInstance == null)
            newTraineeInstance = new NewTraineeWaitingList();
        return newTraineeInstance;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return newTrainingWaitingList.offer(trainee);
    }

    @Override
    public Trainee getFirstInQueue() {
        if (newTrainingWaitingList.size() == 0) {
            return null;
        }
        return newTrainingWaitingList.poll();
    }

    @Override
    public BlockingQueue<Trainee> getWaitingList() {
        return newTrainingWaitingList;
    }

    @Override
    public int sizeOfWaitingList() {
        return newTrainingWaitingList.size();
    }
}
```
The `NewTraineeWaitingList` implements the `WaitingList` interface
and uses a `BlockingQueue` to order the `newTrainingWaitingList` so 
that newer `Trainees` are placed behind older ones in the que.

### Reassign Waiting List
```java
public class ReassignWaitingList implements WaitingList {

    public BlockingQueue<Trainee> reassignWaitingList;
    private static ReassignWaitingList reassignInstance;

    private ReassignWaitingList() {
        this.reassignWaitingList = new LinkedBlockingQueue<>();
    }

    public static ReassignWaitingList getInstance() {
        if (reassignInstance == null)
            reassignInstance = new ReassignWaitingList();
        return reassignInstance;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return reassignWaitingList.offer(trainee);
    }

    @Override
    public Trainee getFirstInQueue() {
        if (reassignWaitingList.size() == 0) {
            return null;
        }
        return reassignWaitingList.poll();
    }

    @Override
    public BlockingQueue<Trainee> getWaitingList() {
        return reassignWaitingList;
    }

    @Override
    public int sizeOfWaitingList() {
        return reassignWaitingList.size();
    }
}
```
The `ReassignWaitingList` implements the `WaitingList` interface
and uses a `BlockingQueue` to order the `ReassignWaitingList`. 
`Trainees`in the `ReassignWaitingList` will be given priority over 
those in the `newTrainingWaitingList`.