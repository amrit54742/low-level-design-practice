package lld.lfu;

class Node {
    int key, value, freq;
    Node prev, next;

    Node(int k, int v) {
        key = k;
        value = v;
        freq = 1;
    }
}