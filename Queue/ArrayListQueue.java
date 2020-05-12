/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

import java.util.ArrayList;

/**
 *
 * @author hp
 * @param <T>
 */
public class ArrayListQueue<T> implements QueueInterface<T> {

    ArrayList<T> queu;

    public ArrayListQueue() {

        this.queu = new ArrayList();
    }

    @Override
    public void enqueue(T newEntry) {
        queu.add(newEntry);
    }

    @Override
    public T dequeue() {
        T result = null;
        if (!queu.isEmpty()) {
            queu.remove(0);
        } else {
            throw new EmptyQueueException("Error");
        }
        return result;

    }

    @Override
    public T getFront() {
        return queu.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queu.isEmpty();
    }

    @Override
    public void clear() {
        while(!queu.isEmpty()){
            dequeue();
        } 
        
        if (!queu.isEmpty()) {
            queu = null;
            queu = new ArrayList<>();
        } else {
            throw new EmptyQueueException("Error");
        }
    }

}
