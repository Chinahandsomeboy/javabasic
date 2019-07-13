package com.pym.finalization;

public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("First print:"+f);
        f=null;
        System.gc();
        //休息一段时间，让上面的垃圾回收线程执行完。
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sencond print："+f);
        System.out.println(f.finalization);
    }
}
/**
 * 期望是：
 * First print:+对象1
 * sencond print：+null
 * Finalized
 * 对象1
 */
