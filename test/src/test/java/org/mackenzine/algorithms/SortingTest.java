package org.mackenzine.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {

    static Stream<Function<int[], int[]>> algorithms() {
        return Stream.of(Sorting.bubbleSort, Sorting.insertionSort, Sorting.selectionSort);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    public void sortOfEmptyArray(Function<int[], int[]> algorithm) {
        int[] elements = new int[0];

        algorithm.apply(elements);

        assertEquals(0, elements.length);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    public void sortOfSingleElement(Function<int[], int[]> algorithm) {
        int[] elements = new int[] { 1 };

        algorithm.apply(elements);

        assertArrayEquals(new int[] { 1 }, elements);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    public void sortOfMultipleElements(Function<int[], int[]> algorithm) {
        int[] elements = new int[] { 3, 1, 2 };

        algorithm.apply(elements);

        assertArrayEquals(new int[] { 1, 2, 3 }, elements);
    }
}
