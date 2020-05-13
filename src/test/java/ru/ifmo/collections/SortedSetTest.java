package ru.ifmo.collections;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortedSetTest {
    @Test
    public void sortedSetTest() {
        SortedSet<Integer> set = SortedSet.create();
        set.add(1);
        set.addAll(Arrays.asList(1, 1, 2, 4, 5, 7, 8, 8));
        set.remove(4);
        assertThat(set.size(), is(5));
        assertThat(set.iterator().next(), is(1));
        assertThat(set.getSorted(), is(Arrays.asList(1, 2, 5, 7, 8)));
        set.removeAll(Arrays.asList(1, 1, 1, 1, 0));
        assertThat(set.getReversed(), is(Arrays.asList(8, 7, 5, 2)));
    }
}
