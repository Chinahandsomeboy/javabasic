package com.pym.javabasic;

import java.util.Random;

public class PermGenErrTest {
    public static void main(String[] args) {
        for (int i=0;i<=1000;i++){
            //将随机的字符串添加到字符串常量池中
            getRandomString(100000).intern();
        }
        System.out.println("misson complete！");
    }

    private static String getRandomString(int length ) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<length;i++){
            int num = random.nextInt(62);
            sb.append(str.charAt(num));
        }
        return sb.toString();
    }
}
