package com.pym.thread_learn;

/**
 * @Author: pym
 * @Date: 2019-6-30 11:19
 * @Version 1.0
 */
public class RunnableDemo {
    public static void main(String[] args) {
        Thread_implements_Runnable m1 = new Thread_implements_Runnable("m1");
        Thread_implements_Runnable m2 = new Thread_implements_Runnable("m2");
        Thread_implements_Runnable m3 = new Thread_implements_Runnable("m3");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
    }
}
