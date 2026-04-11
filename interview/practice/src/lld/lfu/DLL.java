package lld.lfu;

class DLL {
    Node head, tail;
    int size;

    DLL() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void add(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;

        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            remove(last);
            return last;
        }
        return null;
    }
}