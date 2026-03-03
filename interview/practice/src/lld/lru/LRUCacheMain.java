package lld.lru;

import lld.lru.core.LRUCache;

public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache lruCache= new LRUCache(2);
        lruCache.put(1, 100);
        lruCache.put(2, 200);

        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));

        lruCache.put(3, 300);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));


    }

}
