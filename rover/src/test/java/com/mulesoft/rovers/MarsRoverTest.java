package com.mulesoft.rovers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mulesoft.rovers.exceptions.MarsRoverException;
import com.mulesoft.rovers.exceptions.UnrecognizedInstructionException;

public class MarsRoverTest {

	private MarsRover rover1, rover2;

	@BeforeEach
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
	public void shouldThrowExceptionOnUnrecognizedInstruction() {
		assertThrows(UnrecognizedInstructionException.class, () ->rover1.processInstructions("?"));
	}
}
