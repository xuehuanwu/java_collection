package com.java.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap(jdk8，当链表长度大于8，链表变成红黑树)
 * 数据结构是数组+链表。
 * 主结构是数组：java默认长度是16，初始化大小必须为2的幂，默认扩容因子是0.75(达到16*0.75=12后，发生扩容)，每次扩容2倍
 * 从结构是链表：同一个链表所有元素的存储地址是相同的，链表上每个节点就是一个Entry，包括4部分：hash、key、value、next(下一个entry节点的指针)
 * 存储地址：key的hash值%主结构数组长度(取余操作)
 * 注意：java源码中，发生冲突，经过比较不存在相同的key值，则添加到链表前面
 * =====================================================================================================================
 * ConcurrentHashMap
 */
public class MapNotSafe {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> collections = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
