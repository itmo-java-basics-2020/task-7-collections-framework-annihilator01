package ru.ifmo.collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstUniqueTest {
    @Test
    public void firstUniqueTest() {
        FirstUnique firstUnique = new FirstUnique(new int[]{3, 3, 1, 2});
        assertThat(firstUnique.showFirstUnique(), is(1));
        firstUnique.add(1);
        assertThat(firstUnique.showFirstUnique(), is(2));
        firstUnique.add(4);
        assertThat(firstUnique.showFirstUnique(), is(2));
        firstUnique.add(2);
        assertThat(firstUnique.showFirstUnique(), is(4));
        firstUnique.add(4);
        assertThat(firstUnique.showFirstUnique(), is(-1));
    }

    @Test
    public void firstUniqueTest_emptyInitialization() {
        FirstUnique firstUnique = new FirstUnique(new int[0]);
        assertThat(firstUnique.showFirstUnique(), is(-1));
        firstUnique.add(1);
        firstUnique.add(1);
        assertThat(firstUnique.showFirstUnique(), is(-1));
        firstUnique.add(4);
        assertThat(firstUnique.showFirstUnique(), is(4));
        firstUnique.add(2);
        assertThat(firstUnique.showFirstUnique(), is(4));
        firstUnique.add(4);
        assertThat(firstUnique.showFirstUnique(), is(2));
    }
}
