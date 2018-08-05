package org.mackenzine.algorithms;

import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Sorting {

    public static Function<int[], int[]> bubbleSort = elements -> {
        int length = elements.length;
        for (int i = length; i >= 0; i--) {
            IntStream.rangeClosed(0, length - 2)
                    .forEach(swapIfUnordered(elements));
        }
        return elements;
    };

    public static Function<int[], int[]> insertionSort = elements -> {
        int length = elements.length;
        IntStream.rangeClosed(1, length - 1)
                .forEach(i -> {
                    for (int j = i; j > 0; j--) {
                        if (elements[j] < elements[j - 1]) {
                            swap(j, j - 1, elements);
                        }
                    }
                });
        return elements;
    };

    public static Function<int[], int[]> selectionSort = elements -> {
        IntStream.rangeClosed(0, elements.length - 2)
                .forEach(i -> {
                    OptionalInt index = getIndexOfMinimum(elements, i);
                    swap(index.orElse(i), i, elements);
                });
        return elements;
    };

    private static OptionalInt getIndexOfMinimum(int[] elements, int i) {
        return IntStream.rangeClosed(i + 1, elements.length - 1)
                .filter(j -> elements[j] < elements[i])
                .findFirst();
    }

    private static IntConsumer swapIfUnordered(int[] elements) {
        return j -> {
            if (elements[j] > elements[j + 1]) {
                swap(j, j + 1, elements);
            }
        };
    }

    private static void swap(int j, int k, int[] elements) {
        int temp = elements[j];
        elements[j] = elements[k];
        elements[k] = temp;
    }
}
