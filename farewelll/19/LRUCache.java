package nineteen;

import java.util.HashMap;

public class LRUCache {
    private class Node{
        int key, value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = head;
    }
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node currPrev = map.get(key);
        Node curr = currPrev.next;
        if (tail != curr)
        {
            currPrev.next = curr.next;

            map.put(curr.next.key, currPrev);
            map.put(curr.key, tail);

            moveToTail(curr);
        }
        return curr.value;
    }
    public void set(int key, int value) {
        if (get(key) != -1)
        {
            map.get(key).next.value = value;
            Node currPrev = map.get(key);
            Node curr = currPrev.next;
            if (head.next != curr && tail != curr)
            {
                map.put(curr.next.key, currPrev);
                map.put(curr.key, tail);
            }


            return;
        }
        if (map.size() == capacity)
        {
            Node curr = head.next;
            map.remove(curr.key);
            if (head != curr && curr != tail)
            {
                map.put(curr.next.key, head);
            }

            head.next = head.next.next;
        }

        Node newNode = new Node(key, value);
        map.put(key, tail);
        moveToTail(newNode);

    }

    public void moveToTail(Node node)
    {
        tail.next = node;
        tail = tail.next;
        node.next = null;
    }
}