/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.stack;

import java.util.EmptyStackException;

/**
 *
 * @author hp
 */
public class LinkedListStack<SH> implements StackInterface<SH> {

    Node topNode;

    public LinkedListStack() {
        this.topNode = null;
    }

    private class Node {

        SH data;
        Node next;

        public Node(SH data) {
            this.data = data;
        }

        public Node(SH data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    @Override
    public void push(SH newEntry) { //O(1)
        topNode = new Node(newEntry, topNode);
        //////////////////////////////////////////
//        Node newNode=new Node(newEntry);
//          newNode.next=topNode;
//        topNode=newNode;
        //////////////////////////////////////////////////

    }

    @Override
    public SH pop() { //O(1)
        SH res = null;
        res = peek();
        topNode = topNode.next;
        ///////////////////////////////////////////////////
//        if (isEmpty()) {
//          throw new EmptyStackException();
//         } else {
//            res = topNode.data;
//            topNode = topNode.next;
//        }
/////////////////////////////////////////////////////
        return res;

    }

    @Override
    public SH peek() {
        SH result = null;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            result = topNode.data;
        }
        return result;

    }

    @Override
    public boolean isEmpty() { //O(1)
        return topNode == null;
    }

    @Override
    public void clear() { //O(1) or O(N)
        topNode = null;
/////////////////////////////////////////////////////////
//        while (!isEmpty()) {
//            pop();
//        }
  /////////////////////////////////////////////////
    }

}
