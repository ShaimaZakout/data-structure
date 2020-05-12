/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author hp
 */
public class VectorQueue<SH> implements QueueInterface<SH>, Serializable {

    private List<SH> Queue;

    public VectorQueue() {
        Queue = new Vector();
    }

    @Override
    public void enqueue(SH newEntry) {
        Queue.add(newEntry);

    }

    @Override
    public SH dequeue() {
        SH front = getFront();
        Queue.remove(getFront());
        return front;
    }

    @Override
    public SH getFront() {
        SH front;
        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        }
        return Queue.get(0);
    }

    @Override
    public boolean isEmpty() {
     return Queue.isEmpty();
    }

    @Override
    public void clear() {
     Queue.clear();
    }

}
