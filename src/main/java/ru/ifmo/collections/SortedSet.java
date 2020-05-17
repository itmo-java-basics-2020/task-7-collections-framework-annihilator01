package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private final TreeMap<T, Object> contents;
    private final Object control;

    private SortedSet(TreeMap<T, Object> contents) {
        this.contents = contents;
        this.control = new Object();
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T element) {
        return contents.put(element, control) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isChanged = false;
        for (T element: collection) {
            isChanged |= add(element);
        }

        return isChanged;
    }

    @Override
    public boolean remove(Object element) {
        return contents.remove(element, control);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isChanged = false;
        for (Object element: collection) {
            isChanged |= remove(element);
        }

        return isChanged;
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }
}
