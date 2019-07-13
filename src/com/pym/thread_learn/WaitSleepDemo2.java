package com.pym.thread_learn;

/**
 * @Author: pym
 * @Date: 2019-7-3 12:09
 * @Version 1.0
 */

/**
 * 分析：sleep不会释放锁！
 */
public class WaitSleepDemo2 {
    public static void main(String[] args) {
        final Object lock = new Object();
//        new Thread(() -> System.out.println("测试线程的lambda表达式")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        Thread.sleep(1000);
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //为了保证两个线程按顺序执行加入下面的sleep
        //这个sleep是主线程的sleep
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleep 10ms");
                        lock.wait(10);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

