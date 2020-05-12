/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.List;

/**
 *
 * @author hp
 */
public class LList<T> implements ListInterFace<T> {

    private Node head;   // Array of list entries; ignore list[0]
    private int numberOfEntries;

    public LList() {
        head = null;
        numberOfEntries = 0;
    }

    private class Node {

        T data;
        Node next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node getNodeAt(int givenPosition) {
        Node currunt = head;
        // Assertion: (firstNode != null) &&
        //            (1 <= givenPosition) && (givenPosition <= numberOfEntries)
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            for (int i = 1; i < givenPosition; i++) {
                currunt = currunt.next;

            }

        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return currunt;

    }

    @Override
    public void add(int index, T newEntry) {
        if (index >= 1 && index <= numberOfEntries) {
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                head = newNode;
            } else {
                Node lastNode = getNodeAt(index);
                Node BeforNode = getNodeAt(index - 1); //بدي انتبه هنا انه البوسشن القبل والبعد المقصود فيه بالنسبة للمنود الجديدة
                Node AfterNode = BeforNode.next;
                BeforNode.next = newNode;
                newNode.next = AfterNode;
            }
            numberOfEntries++;

        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode;
        }
        numberOfEntries++;

    }

    @Override
    public T remove(int index) {
        T result = null;                           // Return value
        if ((index >= 1) && (index <= numberOfEntries)) {
            if (index == 1) {
                result = head.data;
                head = head.next;
            } else {
                Node BeforNode = getNodeAt(index - 1);
//                Node ReomveNode = BeforNode.next;   //هذه هي الافضل عشان اقلل البك او
                Node ReomveNode = getNodeAt(index);
                result = ReomveNode.data;

                Node aftertoRemove = ReomveNode.next;
                BeforNode.next = aftertoRemove;
            }
            numberOfEntries--;

        } else {

            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
        head = null;
    }

    @Override
    public T set(int index, T anEntry) {
        T result = null;                           // Return value
        if ((index >= 1) && (index <= numberOfEntries)) {
            if (index == 1) {
                result = head.data;
                head.data = anEntry;
            } else {
                Node curNode = getNodeAt(index);
                result = curNode.data;
                curNode.data = anEntry;
            }

        } else {

            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;
    }

    @Override
    public T get(int index) {
        T result = null;                           // Return value
        if ((index >= 1) && (index <= numberOfEntries)) {
//            if (index == 1) {
//                result = head.data;
//            } else {
//                Node BeforNode = getNodeAt(index - 1);
//                Node getNode = BeforNode.next;
//                result = getNode.data;
//            }
            result = getNodeAt(index).data;

        } else {

            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;

    }

    @Override
    public boolean contains(Object anEntry) {
        boolean found = false;
        Node currentNode = head;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        } // end while

        return found;

    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return ((numberOfEntries == 0) && (head == null));
    }

}
