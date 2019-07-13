package com.pym.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Class rc = Class.forName("com.pym.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is "+ rc.getName());
        Method throwHello = rc.getDeclaredMethod("throwHello", String.class);
        //设置私有的权限为可访问
        throwHello.setAccessible(true);
        Object str = throwHello.invoke(r, " bbb");
        System.out.println(str);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r,"ggggg");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        //设置name属性。别忘！
        name.set(r,"pym666");
        sayHi.invoke(r,"ggggg");
    }
}
