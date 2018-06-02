package org.mackenzine.commons;

import java.util.ArrayList;
import java.util.List;

public class Mathematics {

    public static List<Integer> getListOfDigits(int number) {
        int divisor = getPowerOf10(getNumberOfDigits(number));
        List<Integer> digits = new ArrayList<>();
        int current = number;
        do {
            digits.add(current / divisor);
            current %= divisor;
            divisor /= 10;
        } while (divisor > 0);
        return digits;
    }

    public static int getPowerOf10(int numberOfDigits) {
        return Double.valueOf(Math.pow(10, numberOfDigits - 1)).intValue();
    }

    public static int getNumberOfDigits(int number) {
        return Double.valueOf(Math.ceil(Math.log10(number))).intValue();
    }
}
