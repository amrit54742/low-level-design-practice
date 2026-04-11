package lld.lfu;

import java.util.*;

class LFUCache {

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> keyMap;      // key → node
    private Map<Integer, DLL> freqMap;      // freq → DLL

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyMap.size() == capacity) {
                // Evict LFU
                DLL list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                keyMap.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);

            minFreq = 1;

            DLL list = freqMap.getOrDefault(1, new DLL());
            list.add(newNode);
            freqMap.put(1, list);
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);

        list.remove(node);

        // Update minFreq
        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}