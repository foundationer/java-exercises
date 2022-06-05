package org.mackenzine.collections;

import com.google.common.primitives.UnsignedInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PileTest {

    private Pile pile;

    @BeforeEach
    public void setUp() {
        pile = new Pile();
    }

    @Test
    public void emptyPile() {
        assertTrue(pile.isEmpty());
        assertThat(pile.size(), is(equalTo(UnsignedInteger.ZERO)));
    }

    @Test
    public void nonEmptyAfterFirstInsertion() {
        assertFalse(pile.push(1).isPresent());
        assertFalse(pile.isEmpty());
        assertThat(pile.size(), is(equalTo(UnsignedInteger.ONE)));
    }

    @Test
    public void emptyAfterPop() {
        pile.push(1);

        assertThat(pile.pop(), is(equalTo(Optional.of(1))));
        assertTrue(pile.isEmpty());
        assertThat(pile.size(), is(equalTo(UnsignedInteger.ZERO)));
    }

    @Test
    public void exceptionWhenPopOnEmptyPile() {
        assertThrows(PileException.class, () -> pile.pop());
    }

    @Test
    public void topOnEmptyPile() {
        assertFalse(pile.top().isPresent());
    }

    @Test
    public void topOnNonEmptyPile() {
        pile.push(1);
        assertThat(pile.top(), is(equalTo(Optional.of(1))));
    }
}
