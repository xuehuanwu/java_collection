package com.java.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * list集合并集、交集、差集
 */
public class ListMethod {
    public static void main(String[] args) {
        List list1 =new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List list2 =new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        //并集
        list1.addAll(list2);
        list1.stream().forEach(item -> System.out.println(item));
        //交集
        list1.retainAll(list2);
        list1.stream().forEach(item -> System.out.println(item));
        //差集
        list1.removeAll(list2);
        list1.stream().forEach(item -> System.out.println(item));
        //无重复并集
        list2.removeAll(list1);
        list1.addAll(list2);
        list1.stream().forEach(item -> System.out.println(item));

        //iterator遍历集合
        Iterator<String> it=list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }

    /**
     *  for循环遍历集合
     * @param list1
     */
    public static void printStr(List list1){
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}
