package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] numbers) {
        minHeap = new PriorityQueue<>();
        for (int number: numbers) {
            minHeap.add(number);
        }

        while (minHeap.size() > k) {
            minHeap.remove();
        }
    }

    public Integer add(int val) {
        minHeap.add(val);
        minHeap.remove();

        return minHeap.peek();
    }
}