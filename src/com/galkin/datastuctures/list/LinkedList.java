package com.galkin.datastuctures.list;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;


    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        else
            return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        else
            return l.item;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;


    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkIndexToAdd(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;

    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.prev = null;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;

    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;

            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null)
                    return index;
                index--;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item))
                    return index;
                index--;
            }
        }
        return -1;
    }

    @Override
    public void addByIndex(E element, int index) {
        checkIndexToAdd(index);
        if (index == size)
            linkLast(element);
        else
            linkBeforeElem(element, node(index));

    }


    @Override
    public void add(E e) {
        linkLast(e);
    }

    @Override
    public E remove(int index) {
        return unlink(node(index));

    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;

                }
            }
        }
        return false;
    }

    private Node<E> node(int index) {
        checkElementIndex(index);
        if (index < (size << 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void addFirst(E e) {
        linkFirst(e);
    }

    private void addLast(E e) {
        linkLast(e);
    }

    private void linkBeforeElem(E e, Node<E> elem) {
        final Node<E> pred = elem.prev;
        final Node<E> newNode = new Node<>(pred, e, elem);
        elem.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;

        size--;
        return element;
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isIndexToAdd(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
    }

    private void checkIndexToAdd(int index) {
        if (!isIndexToAdd(index))
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size));


    }

    private static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }

    }
}