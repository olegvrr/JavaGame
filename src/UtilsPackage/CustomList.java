/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsPackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Oleg
 */
public class CustomList<T> implements List<T>
{
    private T[] array;
    private T[] buffer;
    
    private int size;
    @Override
    public int size()
    {
        size = 0;
        for(Object o : array)
        {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        return false;
    }

    @Override
    public boolean contains(Object o)
    {
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(T e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T get(int index)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T set(int index, T element)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int index, T element)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T remove(int index)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<T> listIterator()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
