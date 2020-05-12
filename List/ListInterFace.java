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
public interface ListInterFace<T> {

    public void add(int index, T newEntry);
     public void add(T newEntry);
    public T remove(int index);

    public void clear();

    public T set(int index, T anEntry); // Like replace 

    public T get(int index);	// Like getEntry 

    public boolean contains(Object anEntry);

    public int size();	// Like getLength

    public boolean isEmpty();

}
