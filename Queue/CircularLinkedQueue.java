/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

/**
 *
 * @author hp
 */
public class CircularLinkedQueue<SH> implements QueueInterface<SH> {

    private Node queueNode;
    private Node freeNode;

    public CircularLinkedQueue() {
        freeNode = new Node(null, null);
        freeNode.next = freeNode;
        queueNode = freeNode;
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

    
    private boolean newNodeNeeded(){
    return queueNode==freeNode.next;
    
    }
            
    @Override
    public void enqueue(SH newEntry) {
          freeNode.data=newEntry;
          if(newNodeNeeded()){
          Node n=new Node(null,null);
          freeNode.next=n;
          freeNode=n;
           }



    }

    @Override
    public SH dequeue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SH getFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
//       return (freeNode.next==null &&queueNode.next==null);
        return freeNode == queueNode;

    }

    @Override
    public void clear() {
      freeNode=null;
      queueNode=null;
    }

}
