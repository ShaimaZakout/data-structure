package LabDataStructure.stacke;


import java.util.EmptyStackException;
import java.util.Vector;

/**
    A class of stacks whose entries are stored in a vector.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.1

    * toString method overridden to give a better display by Charles Hoot
 * @param <T>
 */
public final class VectorStack<T> implements StackInterface<T> {

    private Vector<T> stack; // Last element is the top entry in stack
    private boolean integrityOK;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public VectorStack(int initialCapacity) {
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity);// Size doubles as needed
        integrityOK = true;
    } // end constructor

    /** Throws an exception if this object is not initialized.
     *
     */
    private void checkIntegrity()
    {
        if (!integrityOK)
             throw new SecurityException("VectorStack object is not initialized " +
                                        "properly.");
   }

    /** Determine if the asked for capacity is less than the maximum.
        @param desiredCapacity The requested capacity for the stack
     */
    private void checkCapacity(int desiredCapacity){
        if (desiredCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end checkCapacity

    /** Adds a new entry to the top of this stack.
    @param newEntry an object to be added to the stack */
    public void push(T newEntry){
        checkIntegrity();
         stack.add(newEntry);

    }

    /** Removes and returns this stack’s top entry.
    @return  The object at the top of the stack.
    @throws EmptyStackException if the stack is empty before the operation. */
    public T pop() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.remove(stack.size() - 1); //عشان اجيب اخر عنصر
            //ليش هنا ماقلت بدنا نحذف  stack.lastElement() 
        }
    } // end pop

    /** Retrieves this stack’s top entry.
    @return The object at the top of the stack or null if
    @throws EmptyStackException if the stack is empty. */
    public T peek(){
        checkIntegrity();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();
    } // end peek

    /** Detects whether this stack is empty.
    @return True if the stack is empty. */
    public boolean isEmpty(){
        return stack.isEmpty();
    } // end isEmpty

    /** Removes all entries from this stack */
    public void clear(){
        stack.clear();
    } // end celar

/** Override the toString() method so that we get a more useful display of
     * the contents in the stack.
     * @return A string representation of the contents of the stack. */
    @Override
    public String toString() {

        String result = "Stack[ ";

        for (int index = 0; index < stack.size(); index++) {
            result += stack.get(index) + " ";
        } // end for

        result += "]*Top*";
        return result;
    }


} // end VectorStack
