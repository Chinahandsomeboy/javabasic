package com.pym.thread_learn;

public class Thread_implements_Runnable implements Runnable{
    private String name;
    public  Thread_implements_Runnable(String name){
        this.name = name;
    };
    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("thread start:"+this.name+",i="+i);
        }
    }
}
