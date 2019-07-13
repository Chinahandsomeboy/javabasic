package com.pym.thread_learn;

import java.util.concurrent.Callable;

/**
 * @Author: pym
 * @Date: 2019-6-30 14:47
 *  和FutureTaskDemo一起
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
