package com.galkin.datastuctures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArrayListTest {
    private ArrayList<Object> list;

    @Before
    public void before() {
        list = new ArrayList<>();
    }


    @Test
    public void testAdd() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(11, list.size());
    }

    @Test
    public void testAddByIndex() {
        assertEquals(0, list.size());
        list.addByIndex(22, 0);
        list.addByIndex(33, 1);
        list.addByIndex(44, 2);
        assertEquals(3, list.size());
        assertEquals(22, list.get(0));
        assertEquals(44, list.get(2));
        assertEquals(33, list.get(1));
        list.addByIndex(55, 1);
        assertEquals(4, list.size());
        assertEquals(55, list.get(1));
    }


    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(5);
        assertTrue(!list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(2));
        assertTrue(!list.contains(3));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
    }

    @Test
    public void testLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        assertEquals(3, list.lastIndexOf(2));
        assertEquals(4, list.lastIndexOf(3));

    }

    @Test
    public void testRemoveByObject() {
        list.add("java");
        list.add("sql");
        list.add("js");
        list.add("c#");
        assertEquals(4, list.size());
        assertEquals("sql", list.get(1));
        list.remove("sql");
        assertEquals(3, list.size());
        assertEquals("js", list.get(1));
        assertEquals(-1, list.indexOf("sql"));
        list.remove("js");
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        list.add("java");
        list.add("sql");
        list.add("js");
        list.add("c#");
        assertEquals(4, list.size());
        assertEquals(1, list.indexOf("sql"));
        list.remove(1);
        assertEquals(-1, list.indexOf("sql"));
        assertEquals(3, list.size());
        assertEquals("js", list.get(1));
    }

    @Test
    public void testSet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(1, list.set(0, 5));
        assertEquals(2, list.set(1, 4));
        assertEquals(5, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(3, list.get(2));
    }


}

