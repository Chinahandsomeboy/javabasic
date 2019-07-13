package com.pym.thread_learn;

public class ThreadTest {
    private static void attack(){
        System.out.println("figth!");
        System.out.println("current thread is "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                attack();
            }
        };
        System.out.println("current main thread is "+Thread.currentThread().getName());
//        thread.run();
        thread.start();
    }
}
