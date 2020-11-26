public class BobLife implements Runnable {
    private static boolean resume;

    @Override
    public void run() {
        wakeUpBob();
        bobGoesToWork();

    }

    public synchronized void wakeUpBob(){
        System.out.println("Bob :: woke up");
        try {
            wait(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bob :: dressed and ready");
    }

    public void bobGoesToWork(){
        System.out.println("Bob :: left to work - as an accountant");
        pauseBob(); // We'll bring him back when The queues are emptied
    }

    private void pauseBob(){
        while (resume = false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resumeBob(){
        resume = true;
    }

}
