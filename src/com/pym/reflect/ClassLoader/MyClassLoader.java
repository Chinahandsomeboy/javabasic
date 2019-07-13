package com.pym.reflect.ClassLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String name;
    private String path;

    public MyClassLoader (String name,String path){
        this.name = name;
        this.path = path;
    }
    //用于寻找类文件

    @Override
    public Class findClass(String name) {
        byte [] b = loadClassData(name);
        return defineClass(name,b,0,b.length);
    }
    // 用于加载类文件
    private byte[] loadClassData(String name) {
        name = path+name+".class";
        InputStream in = null;
        ByteOutputStream out = null;
        try{
            in = new FileInputStream(new File(name));
            out = new ByteOutputStream();
            int i = 0;
            while ((i=in.read()) !=-1){
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
