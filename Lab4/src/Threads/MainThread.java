package Threads;


public class MainThread implements Runnable{
    private Human old = new Human(0);
    private Human young = new Human(1);


    public MainThread() {
        run();
    }

    @Override
    public void run() {
        old.start();
        young.start();
        return;
    }

    public void usePhone() {
        old.num = 1;
    }

    public void surfing() {
        young.num = 2;
    }

    public void closeThreads() {
        old.num = 3;
        young.num = 3;
    }
}
