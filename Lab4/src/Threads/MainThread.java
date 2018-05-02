package Threads;


public class MainThread implements Runnable{
    private Human old = new Human(0);
    private Human young = new Human(1);


    public MainThread() {
        run();
    }

    @Override
    public void run() {
        old.run();
        young.run();
        try {
            old.join();
            young.join();
        } catch (InterruptedException ex) {
            System.out.println("Ожидание завершения главного потока незакончено!");
        }
        return;
    }

    public void usePhone() {
        old.num = 1;
    }
}
