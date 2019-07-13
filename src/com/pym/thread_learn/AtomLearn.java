package com.pym.thread_learn;

import org.junit.Test;

/**
 * @Author: pym
 * @Date: 2019-7-13 11:28
 * @Version 1.0
 */
public class AtomLearn {
    @Test
    public void test20() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            MyThrend thrend = new MyThrend("thead" + i);
            Thread thread = new Thread(thrend);
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(MyCount1.count);
    }

    static class MyThrend implements Runnable {
        private String name;
        MyThrend(String threadName) {
            this.name = threadName;
        }

        @Override
        public void run() {
            for (int i=0;i<20;i++)
                MyCount1.count++;
        }
    }

    private static class MyCount1 {
        static int count = 0;
    }
}


