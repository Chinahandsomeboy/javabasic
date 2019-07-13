package com.pym.thread_learn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: pym
 * @Date: 2019-7-1 9:09
 * @Version 1.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("thread has not finished!please wait!");
        }
        try {
            System.out.println("return value is：" + future.get());
        }catch (ExecutionException e){
            e.printStackTrace();
        }finally {
            //切记关闭线程池
            newCachedThreadPool.shutdown();
        }
    }
}
