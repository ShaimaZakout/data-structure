/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

/**
 *
 * @author hp
 * @param <SH>
 */
public class linkedListQueue<SH> implements QueueInterface<SH> {  //O(1)

    Node front;
    Node back;

    public linkedListQueue() {
        front = back = null;
    }

    private class Node {

        private SH data; // Entry in bag
        private Node next; // Link to next node

        private Node(SH dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(SH dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

    @Override
    public void enqueue(SH newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            front = newNode;
            //back=newNode;     مشتركة بين الحالتين
        }
        back.next = newNode;
        back = newNode;
    }

    @Override
    public SH dequeue() {  //O(1)
        SH result;
        if (isEmpty()) {  //ممكن نستعيض عن هذا البلوك من خلال  getFront
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        } else if (back == front) {  //or if(front.next==null)
            // front= front.next;  مشترك بين الحالتين
            back = null;
        }
        result = front.data;
        front = front.next;
        return result;
    }

    @Override
    public SH getFront() {

        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        }
        return front.data;

    }

    @Override
    public boolean isEmpty() {
        return (front == null && back == null);
     }

    @Override
    public void clear() { //O(1)
       front=back=null;
    }

}
