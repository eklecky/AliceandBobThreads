public class MinionLife extends AliceAndBobChild implements Runnable{
    public MinionLife(String num) {
        super("Minion_" + num);
    }

    @Override
    public void run() {
        try {
            wakeUp();
            getLunchFromAlice();
            goToWork();
            goHome();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}