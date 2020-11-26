public abstract class AliceAndBobChild{

    private final String nameOfChild;
    private boolean isHome;
    private final int DISTANCE_TO_FROM_WORK = 8000;
    private String status;
    private String workPlace;

    private boolean stopRequested = false;

    public AliceAndBobChild(String name){
        nameOfChild = name;
        if (nameOfChild.contains("Gnome_")){
            workPlace = "the Mines";
        }
        else if(nameOfChild.contains("Minion_")){
            workPlace = "the Deli";
        }
    }

    public synchronized void wakeUp() throws InterruptedException {
        System.out.println(nameOfChild + " :: woke up");
        int timeToGetReady = generateRandom(3, 4);
        this.wait(timeToGetReady * 1000);
        System.out.println(nameOfChild + " is dressed and ready");
        this.status = "ready";
    }

    public synchronized void getLunchFromAlice() throws InterruptedException {
        AliceLife.getLunch();
        this.wait(1000);
        System.out.println("Thank you for the lunch Alice.");
    }

    public synchronized void goToWork() throws InterruptedException {
        System.out.println(nameOfChild + " left to work");
        StoryController.numberOfChildrenLeftHome--;
        isHome = false;
        this.wait(DISTANCE_TO_FROM_WORK);
        int timeAtWork = generateRandom(20, 30);
        System.out.println(nameOfChild + " arrived at " + workPlace);
        this.wait(timeAtWork * 1000);
        System.out.printf("%s finished shift -- %d%n", nameOfChild, timeAtWork);
    }

    public synchronized void goHome() throws InterruptedException {
        System.out.println(nameOfChild + " left work");
        this.wait(DISTANCE_TO_FROM_WORK);
        System.out.println(nameOfChild + "  arrived home");
        this.isHome = true;
        this.status = "waiting";
    }

    public synchronized int generateRandom(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public synchronized String getNameOfChild(){
        return nameOfChild;
    }

    public synchronized String getStatus(){
        return this.status;
    }

    public boolean isHome() {
        return isHome;
    }

    public synchronized void requestStop(){
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested(){
        return stopRequested;
    }
}
