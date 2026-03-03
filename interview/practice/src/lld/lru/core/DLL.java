package lld.lru.core;

public class DLL {
    public Node head;
    public Node tail;

    public DLL(){
        head= new Node(-1, -1);
        tail= new Node(-1, -1);

        head.next= tail;
        tail.prev= head;
    }

    public void addToFront(Node cur){
        cur.next= head.next;
        cur.prev= head;

        head.next.prev= cur;
        head.next= cur;

    }

    public Node removeTail(){
        Node lastNode= tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    public void removeNode(Node cur){
        cur.prev.next= cur.next;
        cur.next.prev= cur.prev;
    }




}
