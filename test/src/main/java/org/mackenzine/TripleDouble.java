package org.mackenzine;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static org.mackenzine.commons.Collections.*;
import static org.mackenzine.commons.Mathematics.getListOfDigits;

public class TripleDouble {

    public static boolean isTripleDouble(int tripleCandidate, int doubleCandidate) {
        return matchPatterns(tripleCandidate, 3) && matchPatterns(doubleCandidate, 2);
    }

    private static boolean matchPatterns(int candidate, int length) {
        List<Integer> candidateDigits = getListOfDigits(candidate);
        List<Integer> differentCandidateDigits = getDifferentElements(candidateDigits);
        List<List<Integer>> possiblePatterns = mapRepeat(differentCandidateDigits, length);
        return CollectionUtils.containsAny(consecutiveSubLists(candidateDigits, length), possiblePatterns);
    }
}
