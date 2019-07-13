package com.pym.thread_learn;

public class OrderT1T2T3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"-111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("我正在等待T1执行完成");
                    t1.join();
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"-222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("我正在等待T2执行完成");
                    t2.join();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"-333");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}