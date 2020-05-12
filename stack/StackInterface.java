/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.stack;

/**
 *
 * @author hp
 */
public interface StackInterface <SH>{
    /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(SH newEntry);
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  java.util.EmptyStackException if the stack is empty before the operation. */
   public SH pop();
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  java.util.EmptyStackException if the stack is empty. */
   public SH peek();
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty();
  
   /** Removes all entries from this stack. */
   public void clear();
   
}
