package com.pym.thread_learn;

/**
 * @Author: pym
 * @Date: 2019-7-3 10:49
 * @Version 1.0
 */


/**
 * 分析：wait会释放锁！
 */
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                    System.out.println("thread A get lock");
                    Thread.sleep(20);
                    System.out.println("thread A do wait method");
                    //wait会放弃锁，此时应该执行下面线程的同步方法thread B get lock
                    //lock.wait(1000);
                    //若是不设置时间，需要notify进行唤醒
                    lock.wait();
                    System.out.println("thread A is done");
                    }catch (InterruptedException e){
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
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleep 10ms");
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                        //用于唤醒上面未设置时间的wait()
                        lock.notify();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
