package com.java.collection.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1、故障现象
 * java.util.ConcurrentModificationException 并发修改异常
 * 2、导致原因
 * 并发争抢修改导致
 * 一个线程正在写入，另外一个线程过来抢夺，导致数据不一致，也就是并发修改异常。
 * 3、解决方案
 * 例1 new Vector<>() --> 底层加sync
 * 例2 Collections.synchronizedList(new ArrayList<>());
 * 例3 new CopyOnWriteArrayList<>();
 * =====================================================================================================================
 * CopyOnWriteArrayList 写时复制
 * 说明：往一个容器添加元素时，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行copy，复制出一个新的容器Object[] newElements,
 * 然后往新的容器Object[] newElements里添加元素，添加完元素后，再将原容器的引用指向新的容器setArray(newElements)。
 * 优点：可以对copyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。copyOnWrite也是一种读写分离的思想，读和写不同的容器。
 */
public class ListNotSafe {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> vector = new Vector<>();
        List<String> collections = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
