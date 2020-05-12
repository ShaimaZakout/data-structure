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
public class ArrayQueue<SH> implements QueueInterface<SH> {

    SH[] Queue;
    int front;
    int back;
    static final int DEFULT_CAPCITYE = 21;
    static final int MAX_CAPCTYE = 100;
    boolean isCorrect = false;

    public ArrayQueue(int reqCapcitye) {
        checkCapcty(reqCapcitye);
        Queue = (SH[]) new Object[reqCapcitye];
        isCorrect = true;
        front = back = 0;
    }

    public ArrayQueue() {
        this(DEFULT_CAPCITYE);
    }

    private void checkCapcty(int capcity) {
        if (capcity > MAX_CAPCTYE) {
            throw new IllegalStateException("Attempt to create a stack "
                    + "whose capacity exceeds "
                    + "allowed maximum.");
        }
    }

    private void checkIntegrity() {
        if (!isCorrect) {
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }

    private boolean isFull() {
        return (front == (back + 2) % Queue.length);
    }

    private void doublicet() {
        int newSize = 2 * Queue.length;
        checkCapcty(newSize);
        isCorrect = false;
        SH[] oldeQueue = Queue; //نسخة
        int oldeSize = oldeQueue.length;
        SH[] tempQueue = (SH[]) new Object[newSize];
        Queue = tempQueue;
        for (int i = 0; i < oldeSize; i++) {
            Queue[i] = tempQueue[front];
            front = (front + 1) % Queue.length;
        }
        front = 0;
        back = oldeSize - 2;  //حجم القديمة ناقص اثنين
        isCorrect = true;

    }

    @Override
    public void enqueue(SH newEntry) {
        checkIntegrity();
        if (isFull()) {
            doublicet();;
        }
        back = (back + 1) % Queue.length;
        Queue[back]=newEntry;
       
     }

    @Override
    public SH dequeue() {
        SH result = getFront();
        Queue[front] = null;
        front = (front + 1) % Queue.length;
        return result;
    }

    @Override
    public SH getFront() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyQueueException("Error");
        }
        return Queue[front];

    }

    @Override
    public boolean isEmpty() {
        return front == (back + 1) % Queue.length;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

}
