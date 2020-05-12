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
public interface QueueInterface< SH> {
    
    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    public void enqueue(SH newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public SH dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public SH getFront();

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this queue.
     */
    public void clear();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//
//    /**
//     * Adds a new entry to the back of this queue.
//     *
//     * @param newEntry An object to be added.
//     */
//    public void enqueue(SH newEntry);
//
//    /**
//     * Removes and returns the entry at the front of this queue.
//     *
//     * @return The object at the front of the queue.
//     * @throws EmptyQueueException if the queue is empty before the operation.
//     */
//    public SH dequeue();
//
//    /**
//     * Retrieves the entry at the front of this queue.
//     *
//     * @return The object at the front of the queue.
//     * @throws EmptyQueueException if the queue is empty.
//     */
//    public SH getFront();
//
//    /**
//     * Detects whether this queue is empty.
//     *
//     * @return True if the queue is empty, or false otherwise.
//     */
//    public boolean isEmpty();
//
//    /**
//     * Removes all entries from this queue.
//     */
//    public void clear();
} // end QueueInterface

