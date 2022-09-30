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
public abstract class TrainingCentre implements Comparable<TrainingCentre>{
    protected static int LOCAL_GRACE_PERIOD = 1;
    private static int idCount = 0;
    protected final int id;
    protected Timeable timekeeper;
    protected int timeCreated;
    protected final List<Trainee> trainees;

    public int getId() { return id; }

    public int getTimeCreated() { return timeCreated; }

    public List<Trainee> getTrainees() { return trainees; }

    public TrainingCentre(Timeable timekeeper) {
        this.timekeeper = timekeeper;
        id = idCount++;
        timeCreated = timekeeper.getTime();
        trainees = new ArrayList<>();
    }

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);
    
    ...
}
```
The abstract class has an `int id`, a `Timeable timekeeper`, an `int timeCreated` and a `List<Trainee> trainees`. It also has 3 abstract boolean methods 
called `canBeClosed`, `canAdd`, and `addTrainee`.
### Bootcamp
```java
public class Bootcamp extends TrainingCentre {
    private int closedCounter = 0;

    public Bootcamp(Timeable timekeeper) {
        super(timekeeper);
    }

    @Override
    public boolean canBeClosed() {
        //increment timer, if it is under 25
        if(
                !timekeeper.inGlobalGracePeriod() &&
                (timekeeper.getTime() - timeCreated) > LOCAL_GRACE_PERIOD &&
                trainees.size() < 25)
        {
            closedCounter++;
            return closedCounter > 3;
        }
        closedCounter = 0;
        return false;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                trainees.size() < 500 &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if(!canAdd(trainee)) return false;
        return trainees.add(trainee);
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

## Centre Holder
```java
package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CentreHolder {
    private static CentreHolder instance;
    private final List<TrainingCentre> centres = new ArrayList<>();
    private int removedCentres;

    public List<TrainingCentre> getCentres() { return centres; }

    public int getRemovedCentres() { return removedCentres; }

    public static CentreHolder getInstance() {
        if (instance == null)
            instance = new CentreHolder();
        return instance;
    }

    /**
     * Assigns a trainee to one of the available centres.
     *
     * @param trainee the trainee to be assigned
     * @return {@code null} if the trainee was assigned, <br>
     * the input {@code Trainee} object if not.
     */
    public Trainee assignTrainee(@NotNull Trainee trainee) {
        for (TrainingCentre centre: centres)
            if (centre.addTrainee(trainee))
                return null;
        return trainee;
    }

    public boolean canAddCentre(TrainingCentre centre) {
        return centre != null;
    }

    public boolean addCentre(TrainingCentre centre) {
        if (!canAddCentre(centre)) return false;
        return centres.add(centre);
    }

    public void closeCentre() {
        for (TrainingCentre tc: centres) {
            if (tc.canBeClosed()) {
                centres.remove(tc);
                removedCentres++;
            }
        }
    }
}
```
The `CentreHolder` class keeps track of all `centres` that are currently open as well as how many `centres` have been closed.
The class can add `Trainees` to `centres` and close `centres`.

## Client
```java
public class Client {
    private final Timeable timekeeper;
    private int yearStart;
    private final Course course;
    private final int traineesRequired;
    private final List<Trainee> assignedTrainees;

    public Course getCourse() { return course; }

    public int getTraineesRequired() { return traineesRequired; }

    public Client(Timeable timekeeper) {
        this.timekeeper = timekeeper;
        yearStart = timekeeper.getTime();
        course = Course.getRandomCourse();
        traineesRequired = LinearRandom.nextInt(15, 100, 30, 3);
        assignedTrainees = new ArrayList<>();
    }

    public boolean isUnhappy() {
        int elapsed = timekeeper.getTime() - yearStart;

        if (elapsed < 12) return false;
        if  (elapsed == 12 && assignedTrainees.size() == traineesRequired) { // if happy, restart year
            yearStart = timekeeper.getTime();
            assignedTrainees.clear();
            return false;
        }
        return true;
    }

    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                course == trainee.getCourse() &&
                assignedTrainees.size() < traineesRequired;
    }

    public Trainee addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return trainee;
        assignedTrainees.add(trainee);
        return null;
    }

}
```
The `Client` class represents possible clients of sparta that 
would take trainees on as consultants. When a `Client` is created 
it will pick a random number of trainees it will take, this number
will be in the range of 15 to 100 favouring numbers around 30. If 
the `Client` has been active for a year and hasn't received the number 
of trainees it has asked for, that client will become unhappy.

## Client Holder
```java
public class ClientHolder {

    private final List<Client> clients;
    private int unhappyClients = 0;

    public List<Client> getClients() { return clients; }
    public int getUnhappyClients() { return unhappyClients; }

    public ClientHolder() {
        clients = new ArrayList<>();
    }

    public boolean canAdd(Client client) { return client != null; }

    public boolean addClient(Client client) {
        if (!canAdd(client)) return false;
        return clients.add(client);
    }

    public void removeUnhappyClients() {
        for (Client client: clients) {
            if (client.isUnhappy()) {
                clients.remove(client);
                unhappyClients++;
            }
        }
    }
}
```
The ClientHolder class manages the client objects, it stores all
currently active clients and can remove clients that are unhappy 
after a year.

## Linear Random
```java
public class LinearRandom {
    private static Random random = new Random();

    /**
     * Returns a pseudorandomly chosen {@code int} value between the
     * specified {@code lower} and {@code higher} bounds (inclusive).
     * The chosen {@code int} is linearly distributed towards a {@code bias}.
     * The {@code bias} must fall in between the {@code lower} and {@code upper}.
     * If it falls outside the range, it clips back to the respective edge of the range.
     * The value of {@code skew} must be at least 1. If it isn't, it will default to 1.
     *
     * @param lower the least value that can be returned
     * @param higher the most value that can be returned
     * @param bias the random numbers generated tend towards this number
     * @param skew the amount by which random numbers tend towards the {@code bias}. For a uniform distribution, {@code skew = 1}
     * @return a pseudorandomly chosen {@code int} value between the
     * {@code lower} and {@code higher} bounds (inclusive).
     */
     public static int nextInt(int lower, int higher, int bias, int skew) {
         // make sure parameters are appropriate
         if (lower > higher)
             higher = lower;
         if (bias < lower)
             bias = lower;
         if (bias > higher)
             bias = higher;
         if (skew < 1)
             skew = 1;

         Map<Integer, Integer> rand = new HashMap<>();
         for (int i=0; i<skew; i++) {
             int randVal = random.nextInt(lower, higher+1);
             int distVal = Math.abs(bias - randVal);
             rand.put(distVal, randVal);
         }
         return rand.get(Collections.min(rand.keySet()));
    }
}
```

## Loop
```java
package com.sparta.main.model.util;

/**
 * A class to abstract away running a loop. Whatever functionality is passed to it, will be run in a loop.
 */
public class Loop implements Runnable {

    /**
     * The empty anonymous function that the {@code Loop} runs
     */
    public interface Function {
        /**
         * The method to run the provided function
         */
        void run();
    }

    private final Function function;
    private int numLoops;
    private int loopExecutionTime;

    public int getNumLoops() { return numLoops; }

    public int getLoopExecutionTime() { return loopExecutionTime; }

    public void setNumLoops(int numLoops) { this.numLoops = numLoops; }

    public void setLoopExecutionTime(int loopExecutionTime) { this.loopExecutionTime = loopExecutionTime; }

    /**
     * Creates a main loop object which executes a given function in a loop.
     *
     * @param function the function to run
     */
    public Loop(Function function) {
        this.function = function;
        numLoops = 0;
        loopExecutionTime = 0;
    }

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     */
    public Loop(Function function, int numLoops) {
        this.function = function;
        this.numLoops = numLoops;
        loopExecutionTime = 0;
    }

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     * @param loopExecutionTime the time each loop should execute for (in ms)
     */
    public Loop(Function function, int numLoops, int loopExecutionTime) {
        this.function = function;
        this.numLoops = numLoops;
        this.loopExecutionTime = loopExecutionTime;
    }

    /**
     * Runs the main loop as defined in the constructor.
     */
    @Override
    public void run() {
        for (int i=0; i<numLoops; i++) {
            long start = System.currentTimeMillis();
            function.run();
            long end = System.currentTimeMillis();
            try { Thread.sleep(loopExecutionTime - (end - start)); }
            catch (Exception ignored) {}
        }
    }
}
```

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

## Post Training
```java
public abstract class PostTraining {

    public boolean addTrainee(List<Trainee> list, Trainee trainee) {
        return list.add(trainee);
    };

    public Trainee getFirstTraineeByType(List<Trainee> list, Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        Trainee foundTrainee = list.stream()
                .filter(x -> x.getCourse() == type)
                .findFirst()
                .get();
        return foundTrainee;
    };

    public boolean removeTrainee(List<Trainee> list, Trainee trainee) {
        return list.remove(trainee);
    }

    public Trainee getFirstTrainee(List<Trainee> list) {
        if (list.size() < 1) return null;
        return list.get(0);
    }

    public List<Trainee> getWaitingList(List<Trainee> list) {
        return list;
    };

    public int sizeOfWaitingList(List<Trainee> list) {
        return list.size();
    };

    public int numberOfTraineeOfType(List<Trainee> list, Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        int count = (int) list.stream()
                .filter(x -> x.getCourse() == type)
                .count();
        return count;
    };
}
```
### Reassign Waiting List

```java
package com.sparta.main.model.waitlist.posttraining;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.WaitingList;

import java.util.ArrayList;
import java.util.List;

public class ReassignWaitingList extends WaitingList {

    private List<Trainee> reassignWaitingList;
    private static ReassignWaitingList reassignWaitingListInstance;

    private ReassignWaitingList() {
        reassignWaitingList = new ArrayList<Trainee>();
    }

    public static ReassignWaitingList getInstance() {
        if (reassignWaitingListInstance == null) {
            reassignWaitingListInstance = new ReassignWaitingList();
        }
        return reassignWaitingListInstance;
    }

    public boolean addReassignTrainee(Trainee trainee) {
        return addTrainee(reassignWaitingList, trainee);
    }

    ;

    public Trainee getFirstReassignTraineeByType(Course type) {
        return getFirstTraineeByType(reassignWaitingList, type);
    }

    ;

    public Trainee getFirstReassignTrainee() {
        return getFirstTrainee(reassignWaitingList);
    }

    public List<Trainee> getReassignWaitingList() {
        return getWaitingList(reassignWaitingList);
    }

    ;

    public int sizeOfReassignWaitingList() {
        return sizeOfWaitingList(reassignWaitingList);
    }

    ;

    public int numberOfReassignedTraineeOfType(Course type) {
        return numberOfTraineeOfType(reassignWaitingList, type);
    }

    ;

    public Trainee removeReassignedTrainee(Course type) {
        Trainee foundTrainee = getFirstReassignTraineeByType(type);
        if (removeTrainee(reassignWaitingList, foundTrainee)) {
            return foundTrainee;
        }
        return null;
    }
}
```
~~The `ReassignWaitingList` implements the `WaitingList` interface
and uses a `BlockingQueue` to order the `ReassignWaitingList`. 
`Trainees`in the `ReassignWaitingList` will be given priority over 
those in the `newTrainingWaitingList`.~~

### BenchList
```java
public class BenchList extends PostTraining{

    private List<Trainee> benchWaitingList;
    private static BenchList benchListInstance;

    private BenchList() {
        benchWaitingList = new ArrayList<Trainee>();
    }

    public static BenchList getInstance() {
        if (benchListInstance == null) {
            benchListInstance = new BenchList();
        }
        return benchListInstance;
    }

    public boolean addBenchTrainee(Trainee trainee) {
        return addTrainee(benchWaitingList,trainee);
    };

    public Trainee getFirstBenchTraineeByType(Course type) {
        return getFirstTraineeByType(benchWaitingList, type);
    };

    public Trainee getFirstBenchTrainee() {
        return getFirstTrainee(benchWaitingList);
    }

    public List<Trainee> getBenchWaitingList() {
        return getWaitingList(benchWaitingList);
    };

    public int sizeOfBenchWaitingList() {
        return sizeOfWaitingList(benchWaitingList);
    };

    public int numberOfBenchedTraineeOfType(Course type) {
        return numberOfTraineeOfType(benchWaitingList, type);
    };

    public Trainee removeBenchedTrainee(Course type) {
        Trainee foundTrainee = getFirstBenchTraineeByType(type);
        if (removeTrainee(benchWaitingList,foundTrainee)) {
            return foundTrainee;
        }
        return null;
    }
}
```

## Training view
```java
public class TrainingView {

    static Scanner scn = new Scanner(System.in);  // Create a Scanner object
    static Logger logger = LogManager.getLogger(Starter.class);

    public static boolean getValidBool(String message) {
        System.out.println(message);
        while (true) {
            try {
                int i = scn.nextInt();
                if (i == 0 || i == 1) {
                    if (i == 0) return false;
                    else return false;
                } else System.out.println("Enter 0 or 1");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static int getMonths(String message) throws IllegalArgumentException{
        System.out.println(message);
        while (true) {
            try {
                int userInp = scn.nextInt();
                if (userInp > 2 && userInp < 5000){
                    logger.log(Level.TRACE, String.format("User decided that %s months will be simulated", userInp));
                    return userInp;
                }
                else System.out.println("Enter a number bigger than 1");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

}
```
The `TrainingView` class has two methods, one called `getValidBool` 
that takes in a user input to answer a yes or no question. The other 
method is called `getMonths` and it is used to select how long the
simulation will be running for in months. The simulation need to run
for at least 2 months and at most 4999 months.

## View Status
```java
public class ViewStatus {
    public static void viewStatus(){

        if (TrainingView.getValidBool("Would you like to print the status?")){
            System.out.println("Centres in use:  "+ CentreHolder.getInstance().getCentres());
        }
    }

}
```
The `ViewStatus` class checks if a user wants to see the `centres`
in `CentreHolder` and if so displays them.



## Month Iterator

## Starter

## Main