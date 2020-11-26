public class AliceLife implements Runnable {
    private static boolean resume = true;

    @Override
    public void run() {
        getLunch();
        while (!resume){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getLunchBob();
        while (!resume){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void getLunch(){
        for(AliceAndBobChild child: StoryController.listOfChars){
            if(child.getStatus().equals("ready")){
                System.out.println("Alice :: makes lunch for " + child.getNameOfChild());
                System.out.println("Alice :: Have a good day " + child.getNameOfChild());
                System.out.println("**Alice kisses " + child.getNameOfChild() + " ***");
            }
        }

    }

    public void getLunchBob(){
        System.out.println("Alice :: makes lunch for Bob");
        System.out.println("Alice :: Have a good day Bob, love you.");
        System.out.println("Alice :: kisses Bob");
        pauseAlice();
    }

    public static void pauseAlice(){
        System.out.println("Alice Paused>> ||");
        resume = false;
    }

    public static synchronized void resumeAlice(){
        System.out.println("Alice Resumed>> >");
        resume = true;
    }

    public static Thread yellAtBobToWakeUp(){
        System.out.println("BOB WAKE UP!");
        return new Thread(new BobLife(), "Bob");
    }

    public static void openDoor(){

    }

}