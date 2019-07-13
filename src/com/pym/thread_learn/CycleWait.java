package com.pym.thread_learn;

/**
 * @Author: pym
 * @Date: 2019-6-30 13:44
 * @Version 1.0
 */
public class CycleWait implements Runnable {
    private String value;
    @Override
    public void run() {
        try {
            //假设在执行别的业务需要耗时5ms
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //这时候再赋值
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t1 = new Thread(cw);
        t1.start();
//        while (cw.value == null){
//            Thread.currentThread().sleep(100);
//        }
        t1.join();
        System.out.println("value:"+cw.value);
    }
}
