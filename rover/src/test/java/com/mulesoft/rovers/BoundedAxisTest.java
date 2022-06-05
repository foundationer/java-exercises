package com.mulesoft.rovers;

import com.mulesoft.rovers.exceptions.GridOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoundedAxisTest {

	@Test
	public void shouldThrowExceptionAttemptingToSetNegativeLimit() {
		assertThrows(GridOutOfBoundsException.class, () -> new BoundedAxis(0, -1));
	}

	@Test
	public void shouldThrowExceptionAttemptingToDecrementBelowZero() throws GridOutOfBoundsException {
		BoundedAxis axis = new BoundedAxis(0, 1);

		assertThrows(GridOutOfBoundsException.class, () -> axis.decrement());
	}

	@Test
	public void shouldThrowExceptionAttemptingToIncrementAboveLimit() throws GridOutOfBoundsException {
		BoundedAxis axis = new BoundedAxis(0, 1);

		axis.increment();
		assertThrows(GridOutOfBoundsException.class, () -> axis.increment());
	}

	@Test
	public void shouldIncrementValue() throws GridOutOfBoundsException {
		BoundedAxis axis = new BoundedAxis(0, 1);
		axis.increment();

		assertEquals(1, axis.getValue());
	}

	@Test
	public void shouldDecrementValue() throws GridOutOfBoundsException {
		BoundedAxis axis = new BoundedAxis(1, 1);
		axis.decrement();

		assertEquals(0, axis.getValue());
	}
}
