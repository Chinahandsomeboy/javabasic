package com.pym.thread_learn;

public class Thread_Extends_Thread extends Thread {
    private String name;

    public  Thread_Extends_Thread(String name){
        this.name = name;
    };
    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("thread start:"+this.name+",i="+i);
        }
    }
}
