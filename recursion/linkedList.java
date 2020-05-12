/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabDataStructure.recursion;

/**
 *
 * @author hp
 */
public class linkedList {

    Node head;

    public linkedList() {
        head = null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    class Node {

        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public int countNode(Node head) {
        if (head == null) {
            return 0;
        }
//        System.out.println(head.data);
        return 1+countNode(head.next);

    }
}
