/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.stack;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 *
 * @author hp
 */
public class VectorStack<SH> implements StackInterface<SH> {

    private Vector stack;
    private boolean isCorect;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public VectorStack(int recqeredCapcity) {
        checkCapcty(recqeredCapcity);
        stack = new Vector(recqeredCapcity);
        isCorect = true;

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

    @Override
    public void push(SH newEntry) {
        stack.add(newEntry);
    }

    @Override
    public SH pop() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return (SH) stack.remove(stack.size() - 1);
        }

    }

    @Override
    public SH peek() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return (SH) stack.lastElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
    }

}
