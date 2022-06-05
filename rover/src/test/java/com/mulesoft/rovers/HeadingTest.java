package com.mulesoft.rovers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.mulesoft.rovers.exceptions.HeadingException;

public class HeadingTest {

	private Heading heading;

	@Test
	public void shouldThrowExceptionOnInvalidDirection() throws HeadingException {
		assertThrows(HeadingException.class, () -> new Heading('?'));
	}

	@Test
	public void shouldTurnLeft() throws HeadingException {
		heading = new Heading('N');

		assertEquals('W', heading.turnLeft());
		assertEquals('S', heading.turnLeft());
		assertEquals('E', heading.turnLeft());
		assertEquals('N', heading.turnLeft());
	}

	@Test
	public void shouldTurnRight() throws HeadingException {
		heading = new Heading('N');

		assertEquals('E', heading.turnRight());
		assertEquals('S', heading.turnRight());
		assertEquals('W', heading.turnRight());
		assertEquals('N', heading.turnRight());
	}
}
