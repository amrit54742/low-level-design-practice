package lld.lru.core;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> cacheMap= new HashMap<>();
    private DLL dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new DLL();
    }

    public void put(int key , int value){
        if (cacheMap.containsKey(key)){
            Node cur= cacheMap.get(key);
            cur.value= value;
            dll.removeNode(cur);
            dll.addToFront(cur);
        } else {
            if (capacity== cacheMap.size()){
                Node lastNode= dll.removeTail();
                cacheMap.remove(lastNode.key);
            }
            Node newNode= new Node(key, value);
            dll.addToFront(newNode);
            cacheMap.put(key, newNode);
        }
    }

    public int get(int key){
        if (!cacheMap.containsKey(key)){
            return -1;
        } else {
            Node cur= cacheMap.get(key);
            dll.removeNode(cur);
            dll.addToFront(cur);
            return cur.value;
        }
    }



}
