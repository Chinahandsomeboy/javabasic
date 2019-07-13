package com.pym.thread_learn;

/**
 * @Author: pym
 * @Date: 2019-7-13 12:10
 * @Version 1.0
 */


import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: pym
 * @Date: 2019-7-13 11:28
 * @Version 1.0
 */
public class AtomLearn2 {
    @Test
    public void test20() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            MyThrend thrend = new MyThrend("thead" + i);
            Thread thread = new Thread(thrend);
            thread.start();
        }
        Thread.sleep(2000);
//        使用.get()获取
        System.out.println(MyCount1.count.get());
    }

    static class MyThrend implements Runnable {
        private String name;
        MyThrend(String threadName) {
            this.name = threadName;
        }

        @Override
        public void run() {
            for (int i=0;i<20;i++)
                MyCount1.count.getAndIncrement();
        }
    }

    private static class MyCount1 {
//        原子操作
        static AtomicInteger count = new AtomicInteger(0);
    }
}



