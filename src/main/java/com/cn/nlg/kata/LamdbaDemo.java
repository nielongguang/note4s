package com.cn.nlg.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Stream.of;

public class LamdbaDemo {

    Integer [] integers =  {1,4,566,1235,61,34};
    List<Integer> list = Arrays.asList(1, 3, 5, 15, 6, 124, 1234);


    //1.lamdba 排序
    @Test
   public void sortDemo(){
        //这种操作会把所有的 元素转换为 List<Integer>
       of(list).forEach(System.out::println);
       of(list).forEachOrdered(System.out::println);
       //把list转换为流的正确姿势 转换为Integer
        list.stream().sorted(Integer::compareTo).forEach(System.out::println);

   }

    //2.lamdba求和
    @Test
   public void sumDemo(){
      Optional<Integer> integer= list.stream().reduce((o1, o2)->o1+o2);
        System.out.println(integer.orElse(1));
    }

    //3.ladba reduce 操作

    //4.多个流合并

    //5.根据 逻辑器筛选

    //6.映射
}
