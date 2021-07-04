package com.java.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * HashSet底层是HashMap
 * 问题：HashSet的add方法只有一个参数，而HashMap是key-value键值对？？？
 * 答案：add只需要传入一个key值，value值是new Object()常量。
 */
public class SetNotSafe {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> collections = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
