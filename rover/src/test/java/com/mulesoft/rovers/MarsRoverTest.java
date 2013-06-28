package com.mulesoft.rovers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mulesoft.rovers.exceptions.MarsRoverException;
import com.mulesoft.rovers.exceptions.UnrecognizedInstructionException;

public class MarsRoverTest {

	private MarsRover rover1, rover2;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws MarsRoverException {
		rover1 = new MarsRover(new Position(new BoundedAxis(1, 5), new BoundedAxis(2, 5), new Heading('N')));
		rover2 = new MarsRover(new Position(new BoundedAxis(3, 5), new BoundedAxis(3, 5), new Heading('E')));
	}

	@Test
	public void shouldProcessInstructionsCorrectly() throws MarsRoverException {
		Position position1 = rover1.processInstructions("LMLMLMLMM");

		assertEquals(1, position1.getxAxis());
		assertEquals(3, position1.getyAxis());
		assertEquals('N', position1.getHeading().toChar());

		Position position2 = rover2.processInstructions("MMRMMRMRRM");

		assertEquals(5, position2.getxAxis());
		assertEquals(1, position2.getyAxis());
		assertEquals('E', position2.getHeading().toChar());
	}

	@Test
	public void shouldThrowExceptionOnUnrecognizedInstruction() throws MarsRoverException {
		exception.expect(UnrecognizedInstructionException.class);

		rover1.processInstructions("?");
	}
}
