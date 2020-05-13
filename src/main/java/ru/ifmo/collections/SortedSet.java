package ru.ifmo.collections;

import java.util.AbstractSet;
import java.util.Comparator;

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
public abstract class SortedSet<T> extends AbstractSet<T> {
    // private final Map<???, ???> contents; TODO decide Map implementation and key/value types. "???" is used just as an example
    public static <T> SortedSet<T> create() {
        throw new UnsupportedOperationException(); // TODO implement
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        throw new UnsupportedOperationException(); // TODO implement
    }

    public T[] getSorted() {
        throw new UnsupportedOperationException(); // TODO implement
    }

    public T[] getReversed() {
        throw new UnsupportedOperationException(); // TODO implement
    }
}
