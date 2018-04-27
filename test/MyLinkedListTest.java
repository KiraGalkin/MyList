import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {
    MyLinkedList<Object> list;

    @Before
    public void before() {
        list = new MyLinkedList<>();
    }

    @Test
    public void TestAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        list.addFirst(2);
        assertEquals(2, list.getFirst());

    }

    @Test
    public void TestAddLast() {

        list.addLast(1);
        assertEquals(1, list.getLast());
        list.addLast(2);
        assertEquals(2, list.getLast());

    }

    @Test
    public void TestSize() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());


    }

    @Test
    public void TestIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(2);
        assertTrue(!list.isEmpty());

    }

    @Test
    public void TestContains() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(2));
        assertTrue(!list.contains(4));
    }

    @Test
    public void TestGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    public void TestSet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        list.set(1, 5);
        assertEquals(5, list.get(1));

    }

    @Test
    public void TestClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());

    }

    @Test
    public void TestIndexOf() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(1);
        assertEquals(1, list.indexOf(2));
        assertEquals(0, list.indexOf(1));

    }

    @Test
    public void TestLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(1);
        assertEquals(3, list.lastIndexOf(2));
        assertEquals(4, list.lastIndexOf(1));

    }

    @Test
    public void TestAddByIndex() {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        list.addByIndex(6, 1);
        list.addByIndex(7, 2);
        assertEquals(6, list.get(1));
        assertEquals(7, list.get(2));
    }

    @Test
    public void TestAdd() {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(3, list.size());
    }


    @Test
    public void TestRemove() {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        list.remove(new Integer(1));
        assertEquals(2, list.get(0));
        list.remove(new Integer(2));
        assertEquals(4, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void TestRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        list.remove(0);
        assertEquals(2,list.get(0));
        list.remove(0);
        assertEquals(4,list.get(0));
        assertEquals(1, list.size());

    }

}