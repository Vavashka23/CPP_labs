package Threads;

import Check.AccessPoint;

public class Human extends Thread{
    private int generation;
    private AccessPoint point = new AccessPoint();
    public int num;

    public Human(int gen) {
        this.generation = gen;
        this.num = 0;
    }

    @Override
    public void run() {
        if(this.generation == 0) {
            try {
                while (true) {
                    if(num == 1) call();

                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {

        }
        return;
    }

    public void call() {
        point.check();

    }

    public void useInternet() {

    }
}