import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {

    private Object[] data;
    private int size;


    MyArrayList() {
        data = new Object[10];
    }

    @SuppressWarnings("unchecked")
   private E data(int index) {
        return (E) data[index];
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
        checkIndex(index);
        Objects.checkIndex(index, size);
        return data(index);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = data(index);
        data[index] = element;
        return oldValue;

    }

    @Override
    public void clear() {
        final Object[] es = data;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (data[i] == null)
                    return i;

        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(data[i]))
                    return i;

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (data[i] == null)
                    return i;

        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o == data[i])
                    return i;

        }
        return -1;
    }


    @Override
    public void addByIndex(E element, int index) {
        checkIndexToAdd(index);
        final int s;
        Object[] data;
        if ((s = size) == (data = this.data).length)
            data = grow();
        System.arraycopy(data, index, data, index + 1, s - index);
        data[index] = element;
        size = s + 1;

    }

    @Override
    public void add(E e) {
        addByIndex(e, size);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = data(index);
        fastRemove(index);
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (data[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(data[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;

    }

    private Object[] grow() {
        Object[] newData = new Object[(data.length + 1)];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        return data;
    }


    private void checkIndexToAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index must be between 0 and " + (data.length - 1));
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be between 0 and " + size);

        }
    }
}

/*        for (int i = 0; i < size; i++){
            if ()
        }
*/