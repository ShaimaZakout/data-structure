/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author hp
 * @param <SH>
 */
//public class proiportyQueue<SH extends Object> implements Serializable {
//    linkedListQueue<SH> q1;
//    linkedListQueue<SH> q2;
//    linkedListQueue<SH> q3;
//    
  class Node {
    int key;
    int value;
    Node pre;
    Node next;
     public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache  //implements Comparable<Object>{
{

    private HashMap<Integer, Node> map;
    private int capicity, count;
    private Node head, tail;

    
    
    
    public LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    // This method works in O(1) 
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : "
                    + result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value"
                + " for the key: " + key);
        return -1;
    }

    // This method works in O(1) 
    public void set(int key, int value) {
        System.out.println("Going to set the (key, "
                + "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

//    @Override
//    public int compareTo(Object t) {
//        new Node(k, v);
//        
//    }
}

public class TestLRUCache {

    public static void main(String[] args) {
        System.out.println("Going to test the LRU "
                + " Cache Implementation");
        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value  
        // 10 in the cache. 
        cache.set(1, 10);

        // it will store a key (1) with value 10 in the cache. 
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is "
                + cache.get(1)); // returns 10 

        // evicts key 2 and store a key (3) with 
        // value 30 in the cache. 
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is "
                + cache.get(2)); // returns -1 (not found) 

        // evicts key 1 and store a key (4) with 
        // value 40 in the cache. 
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is "
                + cache.get(1)); // returns -1 (not found) 
        System.out.println("Value for the key: 3 is "
                + cache.get(3)); // returns 30 
        System.out.println("Value for the key: 4 is "
                + cache.get(4)); // return 40 
    }
}

//    prQueue firstPQ;
//    prQueue backPQ;
//
//    public proiportyQueue() {
//        firstPQ = null;
//        backPQ = null;
//    }
//
//    private class prQueue<SH> extends linkedListQueue<SH> {
//         SH pri;
//        Comparator<SH> com;
//        private prQueue next;
//
//        public prQueue(prQueue next) {
//            this.next = next;
//        }
//
//        public prQueue() {
//            pri = null;
//        }
//
//        public int compare(SH t, SH t1) {
//            return com.compare(t, t1);
//        }
//    }
//
//    public void add(EnteryPri<SH> n) {
//        prQueue qq;
//        if (isEmpty()) {
//            qq = new prQueue();
//            firstPQ = qq;
//            backPQ = qq;
//            qq.pri = n.pro;
//            qq.enqueue(n);
//
//        } else {
//            boolean found = false;
//            prQueue cuurent = firstPQ;
//            while (cuurent != null && !found) {
//                if (cuurent.pri.equals(n.pro)) {
//                    cuurent.enqueue(n);
//                    found = true;
//                } else {
//                    qq = new prQueue();
//                    backPQ.next = qq;
//                    backPQ = qq;
//                    qq.pri = n.pro;
//                }
//                cuurent = cuurent.next;
//            }
//
//         
//
//    }}
//
//    public boolean isEmpty() {
//        return (firstPQ == null) && (backPQ == null);
//    }

