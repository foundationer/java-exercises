package org.mackenzine.algorithms;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.function.Function;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class SortingTest {

    @DataPoints
    public static Function<int[], int[]>[] dataPoints = new Function[] { Sorting.bubbleSort, Sorting.insertionSort,
            Sorting.selectionSort };

    @Theory
    public void sortOfEmptyArray(Function<int[], int[]> algorithm) {
        int[] elements = new int[0];

        algorithm.apply(elements);

        assertEquals(0, elements.length);
    }

    @Theory
    public void sortOfSingleElement(Function<int[], int[]> algorithm) {
        int[] elements = new int[] { 1 };

        algorithm.apply(elements);

        assertArrayEquals(new int[] { 1 }, elements);
    }

    @Theory
    public void sortOfMultipleElements(Function<int[], int[]> algorithm) {
        int[] elements = new int[] { 3, 1, 2 };

        algorithm.apply(elements);

        assertArrayEquals(new int[] { 1, 2, 3 }, elements);
    }
}
