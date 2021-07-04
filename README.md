list集合
是一个继承于Collection的接口，是有序的队列，允许有重复的元素
ArrayList：是一个动态数组，查询快，插入删除慢
LinkedList：是一个双向链表，插入删除快，查询慢

set集合
是一个继承于Collection的接口，是无序的队列，不允许有重复的元素
HashSet：堪称查询速度最快的集合，因为其内部是以HashCode来实现的
TreeSet：是二叉树实现的，基于TreeMap，生成一个总是处于排序状态的set

map
是由一系列键值对组成的集合，提供了key到Value的映射，不能存在相同的key值，value值可以相同
HashMap：以哈希表数据结构实现，查找对象时通过哈希函数计算其位置，它是为快速查询而设计的，其内部定义了一个hash表数组（Entry[] table），
元素会通过哈希转换函数将元素的哈希地址转换成数组中存放的索引，如果有冲突，则使用散列链表的形式将所有相同哈希地址的元素串起来，
可能通过查看HashMap.Entry的源码它是一个单链表结构
TreeMap：有序散列表，实现SortedMap接口，底层通过红黑树实现