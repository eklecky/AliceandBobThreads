public class GnomeLife extends AliceAndBobChild implements Runnable{
    public GnomeLife(String num) {
        super("Gnome_" + num);
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