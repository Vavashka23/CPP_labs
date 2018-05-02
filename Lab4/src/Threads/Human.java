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
                do {
                    if (num == 1) call();
                }while (num == 3);
        } else if(this.generation == 1){
            do {
                if (num == 2) useInternet();
            }while (num == 3);
        } else System.out.println("Fatal error!!!");
        return;
    }

    public void call() {
        if(point.check() == 0 || point.check() == 1) {
            point.internetAccess = false;
            point.phoneAccess = false;
            try {
                wait(30000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            point.phoneAccess = true;
            point.internetAccess = true;
        }
    }

    public void useInternet() {
        if(point.check() == 0 || point.check() == 1) {
            point.internetAccess = false;
            try {
                wait(30000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            point.internetAccess = true;
        }
    }
}