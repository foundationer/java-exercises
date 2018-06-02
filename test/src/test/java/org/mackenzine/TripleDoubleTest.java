package org.mackenzine;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TripleDoubleTest {

    @Test
    public void testAllDigitsEqual() {
        assertTrue(TripleDouble.isTripleDouble(111, 22));
    }

    @Test
    public void testAllDigitsNotEqual() {
        assertTrue(TripleDouble.isTripleDouble(21113, 1223));
    }

    @Test
    public void testNonConsecutiveDigits() {
        assertFalse(TripleDouble.isTripleDouble(2141513, 1242523));
    }
}
