package org.mackenzine.collections;

import com.google.common.primitives.UnsignedInteger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PileTest {

    private Pile pile;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
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
        exception.expect(PileException.class);
        exception.expectMessage("Attempt to pop element from empty pile!");

        pile.pop();
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
