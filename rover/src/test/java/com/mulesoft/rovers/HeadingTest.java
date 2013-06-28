package com.mulesoft.rovers;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mulesoft.rovers.exceptions.HeadingException;

public class HeadingTest {

	private Heading heading;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldThrowExceptionOnInvalidDirection() throws HeadingException {
		exception.expect(HeadingException.class);
		exception.expectMessage("Wrong heading");

		new Heading('?');
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
