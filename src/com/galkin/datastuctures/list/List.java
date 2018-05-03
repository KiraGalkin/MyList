package com.galkin.datastuctures.list;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    E get(int index);

    E set(int index, E element);

    void clear();

    int indexOf(E o);

    int lastIndexOf(E o);

    void addByIndex(E element, int index);

    void add(E e);

    E remove(int index);

    boolean remove(Object o);
}
