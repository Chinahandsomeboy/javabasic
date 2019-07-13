package com.pym.thread_learn;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread_Extends_Thread t1 = new Thread_Extends_Thread("t1");
        Thread_Extends_Thread t2 = new Thread_Extends_Thread("t2");
        Thread_Extends_Thread t3 = new Thread_Extends_Thread("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
