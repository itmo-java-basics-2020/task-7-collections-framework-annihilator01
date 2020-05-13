package ru.ifmo.collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KthLargestTest {
    @Test
    public void kthLargestTest() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3), is(4));
        assertThat(kthLargest.add(5), is(5));
        assertThat(kthLargest.add(10), is(5));
        assertThat(kthLargest.add(9), is(8));
        assertThat(kthLargest.add(4), is(8));
    }
}
