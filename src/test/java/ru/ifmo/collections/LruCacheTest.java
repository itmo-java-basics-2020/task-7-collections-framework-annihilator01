package ru.ifmo.collections;

import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LruCacheTest {
    @Test
    public void testLruCache() {
        LruCache<Integer, Integer> cache = new LruCache<>(2);

        cache.put(1, 1);
        assertThat(cache.elements(), is(1));
        cache.put(2, 2);
        assertThat(cache.get(1), is(1));
        assertThat(cache.elements(), is(2));
        cache.put(3, 3);
        assertThat(cache.elements(), is(2));
        assertThat(cache.get(2), is(nullValue()));
        cache.put(4, 4);
        assertThat(cache.elements(), is(2));
        assertThat(cache.get(1), is(nullValue()));
        assertThat(cache.get(3), is(3));
        assertThat(cache.get(4), is(4));

        assertThat(Arrays.stream(cache.getClass().getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .count(), is(3L));
    }
}