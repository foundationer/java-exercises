package com.mulesoft.rovers;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mulesoft.rovers.exceptions.GridOutOfBoundsException;

public class BoundedAxisTest {

	private BoundedAxis axis;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldThrowExceptionAttemptingToSetNegativeLimit() throws GridOutOfBoundsException {
		exception.expect(GridOutOfBoundsException.class);

		axis = new BoundedAxis(0, -1);
	}

	@Test
	public void shouldThrowExceptionAttemptingToDecrementBelowZero() throws GridOutOfBoundsException {
		exception.expect(GridOutOfBoundsException.class);

		axis = new BoundedAxis(0, 1);
		axis.decrement();
	}

	@Test
	public void shouldThrowExceptionAttemptingToIncrementAboveLimit() throws GridOutOfBoundsException {
		exception.expect(GridOutOfBoundsException.class);

		axis = new BoundedAxis(0, 0);
		axis.increment();
	}

	@Test
	public void shouldIncrementValue() throws GridOutOfBoundsException {
		axis = new BoundedAxis(0, 1);
		axis.increment();

		assertEquals(1, axis.getValue());
	}

	@Test
	public void shouldDecrementValue() throws GridOutOfBoundsException {
		axis = new BoundedAxis(1, 1);
		axis.decrement();

		assertEquals(0, axis.getValue());
	}
}
