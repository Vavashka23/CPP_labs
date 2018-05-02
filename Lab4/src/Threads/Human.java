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
            System.out.println("Запуск 1-го потока");
            do {
                if (num == 1) {

                    System.out.println("Запрос на пользование телефоном");
                    call();
                    num = 0;
                }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}

            }while(true);
        } else if(this.generation == 1){
            System.out.println("Запуск 2-го потока");
            do {
                if (num == 2) {
                    System.out.println("Запрос на пользование интернетом");
                    useInternet();
                    num = 0;
                }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}

            }while(true);
        } else System.out.println("Fatal error!!!");
    }

    public void call() {
        if(point.check() == 0) {
            System.out.println("Начало использования телефона");
            point.internetAccess = false;
            point.phoneAccess = false;
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Конец использования телефона");
            point.phoneAccess = true;
            point.internetAccess = true;
        } else if (point.check() == 1) {
            System.out.println("Ожидание завершения интернет-соединение");
            while(point.check() != 0)
            {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Начало использования телефона");
            point.internetAccess = false;
            point.phoneAccess = false;
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Конец использования телефона");
            point.phoneAccess = true;
            point.internetAccess = true;
        }
    }

    public void useInternet() {
        if(point.check() == 0 || point.check() == 1) {
            System.out.println("Начало использования интернета");
            point.internetAccess = false;
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Конец использования интернета");
            point.internetAccess = true;
        } else System.out.println("Запрос отклонён");
    }
}