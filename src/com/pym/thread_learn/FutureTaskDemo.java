package com.pym.thread_learn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: pym
 * @Date: 2019-6-30 14:50
 * 和MyCallable一起
 * @Version 1.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //为何可以放入Callable()实例进去？---查看FutureTask源码
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        //为何
        Thread thread = new Thread(task);
        thread.start();
        //isDone判断Callable()传进去的实例的call方法是否执行完成！
        if (!task.isDone()){
            System.out.println("thread has not finished!please wait!");
        }
//        获取get()子线程处理完成后的返回值
        //get()还有个timeout参数的，如果超时未获得call方法的返回值，就跑出TimeoutException异常
        System.out.println("task return:" + task.get());
    }
}
