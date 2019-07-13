package com.pym.reflect.ClassLoader;

public class ClassLoaderCheck {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("my","D:\\classloader\\");
        Class c = m.loadClass("Wali");
        System.out.println(c.getClassLoader());
        //为了让wali中的static代码运行。
        c.newInstance();
    }
}
