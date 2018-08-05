package org.mackenzine.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListingTest {

    private Listing<Integer> listing;

    @Before
    public void setUp() {
        listing = new Listing<>();
    }

    @Test
    public void reverseEmptyList() {
        assertEquals(listing, listing.reverse());
    }

    @Test
    public void reverseListingWithSingleElement() {
        listing.add(1);
        assertEquals(listing.getFirst().intValue(), listing.reverse().getFirst().intValue());
    }

    @Test
    public void reverseListingWithMultipleElements() {
        listing.add(1);
        listing.add(2);

        Listing<Integer> reversed = listing.reverse();

        assertEquals(listing.getFirst().intValue(), reversed.getLast().intValue());
        assertEquals(listing.getLast().intValue(), reversed.getFirst().intValue());
    }
}
