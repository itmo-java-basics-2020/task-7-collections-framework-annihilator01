package ru.ifmo.collections;

import java.util.LinkedHashMap;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {

    private final LinkedHashMap<K, V> cache;
    private int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        V value = cache.get(key);
        raiseToTop(key, value);

        return value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
             raiseToTop(key, value);
        } else {
            if (cache.size() == capacity) {
                cache.remove(cache.keySet().iterator().next());
            }

            cache.put(key, value);
        }
    }

    private void raiseToTop(K key, V value) {
        cache.remove(key);
        cache.put(key, value);
    }

    public int elements() {
        return cache.size();
    }
}
