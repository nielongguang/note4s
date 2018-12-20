package com.cn.nlg.kata;

import java.util.Collections;
import java.util.HashMap;

public class sf {

    public static void main(String[] args) {
        System.out.println("args = [" +  Collections.EMPTY_LIST==null + "]");
        HashMap hashMap=new HashMap();
        hashMap =null;
        System.out.println(hashMap==null);
        Integer integer =null;
       System.out.println(integer==null);


    }
}
