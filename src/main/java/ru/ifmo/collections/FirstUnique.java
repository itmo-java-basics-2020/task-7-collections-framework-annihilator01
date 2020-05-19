package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 * 0_o
 */
public class FirstUnique {

    private final HashMap<Integer, Integer> numberCount;
    private final LinkedList<Integer> order;

    public FirstUnique(int[] numbers) {
        numberCount = new HashMap<>();
        order = new LinkedList<>();

        for (int number: numbers) {
            if (numberCount.putIfAbsent(number, 1) != null) {
                numberCount.computeIfPresent(number, (k, v) -> ++v);
            }

            order.add(number);
        }
    }

    public int showFirstUnique() {
        while (order.peek() != null) {
            if (numberCount.get(order.getFirst()) == 1) {
                return order.getFirst();
            }

            order.remove();
        }

        return -1;
    }

    public void add(int value) {
        if (numberCount.putIfAbsent(value, 1) != null) {
            numberCount.computeIfPresent(value, (k, v) -> ++v);
        } else {
            order.add(value);
        }
    }
}
