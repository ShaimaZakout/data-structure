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
public class DoublyLinkedADeque_doubleEndedQueue_<SH> implements doubleEndedQueueInterface<SH> {

    Node front;
    Node back;

    public DoublyLinkedADeque_doubleEndedQueue_() {
        front = null;
        back = null;
    }

    @Override
    public SH getFront() {

        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        }
        return front.data;

    }

    public SH getBack() {

        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        }
        return back.data;

    }

    @Override
    public boolean isEmpty() {
        return (front == null) && (back == null);
    }

    @Override
    public void clear() {
        front = null;
        back = null;
    }

    @Override
    public void addBack(SH newEntry) {
        Node newNode = new Node(newEntry, null, null);
        if (isEmpty()) {
            front = newNode;
            //back=newNode;     مشتركة بين الحالتين
        }
        back.next = newNode;
        back = newNode;
    }

    @Override
    public SH removeFront() {
        SH re = getFront();
        if (front == null) {
            back = null;
        }
        front = front.next;
        front.previous = null;
        return re;
    }

    @Override
    public SH removeBack() {
        SH backNode = getBack();
        back = back.previous;   //مشترك بين الحاتلين
        if (back == null) { //في حالة عنصر واحد
            front = null;
        } else {    //في حالة في عدة عناصر
            back.next = null;
        }
        return backNode;
    }

    private class Node {

        private SH data; // Entry in bag
        private Node next; // Link to next node
        private Node previous;

        private Node(SH dataPortion) {
            this(dataPortion, null, null);
        } // end constructor

        // end constructor
        public Node(SH data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    } // end Node

    @Override
    public void addFront(SH newEntry) {
        Node newNode = new Node(newEntry, null, null);
        if (isEmpty()) {
            back = newNode;
            // front = newNode; مشتركة بين الحالتين
        }
        front.previous = newNode;
        front = newNode;
        /////////////////////////////////
//        newNode.next = front;  
//        front = newNode;
//        front.previous = null;
        //////////////////////////////////////

    }

}
