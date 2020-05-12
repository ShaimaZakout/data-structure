/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author hp
 */
public class ArrayStack<SH> implements StackInterface<SH> {

    private SH[] stack;
    private boolean isCorect;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private int top;

    public ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayStack(int reqerdcapity) {
        checkCapcty(reqerdcapity);
        SH[] tempStack = (SH[]) new Object[reqerdcapity];
        stack = tempStack;
        isCorect = true;
         top = -1;

    }

    private void checkIntegrity() {
        if (!isCorect) {
            throw new SecurityException("VectorStack object is not initialized "
                    + "properly.");
        }
    }

    private void checkCapcty(int capcity) {
        if (capcity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a stack "
                    + "whose capacity exceeds "
                    + "allowed maximum.");
        }
    }

    private boolean isFull() {
        return top >= stack.length - 1;
    }

    @Override
    public void push(SH newEntry) { //O(nlogN)
        checkIntegrity();
        if (isFull()) {
            duoblicet();
        }
        stack[++top] = newEntry;
    }

    private void duoblicet() { //O(nlogN)
        int newCapctiy = 2 * stack.length;
        checkCapcty(newCapctiy);
        stack = Arrays.copyOf(stack, newCapctiy);

    }

    @Override
    public SH pop() { //O(1)
        SH result = null;
        checkIntegrity();
        if (!isEmpty()) {
            ////////////////////////////////////////////////////         
//       result=stack[top];
//       stack[top]=null;
//       top--;
///////////////////////////////////////////////////////////
            result = stack[top--];
         }
        else{
         throw new EmptyStackException();
         }
        return result;
    }

    @Override
    public SH peek() { //O(1)
     SH result=null;
     if(isEmpty())
               throw new EmptyStackException();
     else{
         result=stack[top];
     }
     return result;
    }

    @Override
    public boolean isEmpty() { //O(1)
        return top == -1;   //top<0   
    }

    @Override
    public void clear() {   //O(N)
        while (!isEmpty()) {
            pop();
        }
    }

}
