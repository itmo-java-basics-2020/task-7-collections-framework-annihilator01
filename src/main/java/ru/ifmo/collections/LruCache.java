package ru.ifmo.collections;

import java.util.HashMap;

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

    private HashMap<K, Node<K, V>> cache;
    private Node<K, V> head, tail;
    private int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K, V> node = cache.get(key);
        raiseNodeToHead(node);

        return node.val;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.val = value;
            raiseNodeToHead(node);
        } else {
            if (cache.size() == capacity) {
                removeCached(tail);
            }

            Node<K, V> newNode = new Node<>();
            newNode.key = key;
            newNode.val = value;
            addCached(newNode);
        }
    }

    private void raiseNodeToHead(Node<K, V> node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void addCached(Node<K, V> node) {
        cache.put(node.key, node);
        addNodeToHead(node);
    }
    private void removeCached(Node<K, V> node) {
        cache.remove(node.key);
        removeNode(node);
    }

    private void addNodeToHead(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        head.left = node;
        node.right = head;
        head = node;
    }

    private void removeNode(Node<K, V> node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            head = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            tail = node.left;
        }
    }

    public int elements() {
        return cache.size();
    }

    static class Node<K, V> {
        K key;
        V val;
        Node<K, V> left;
        Node<K, V> right;
    }
}
