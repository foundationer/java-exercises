package com.mulesoft.rovers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mulesoft.rovers.exceptions.MarsRoverException;

@RunWith(MockitoJUnitRunner.class)
public class PositionTest {

	private Position position;

	@Mock private BoundedAxis xAxis;
	@Mock private BoundedAxis yAxis;
	@Mock private Heading heading;

	@Before
	public void setUp() {
		position = new Position(xAxis, yAxis, heading);
	}

	@Test
	public void shouldPerformStepHeadingNorth() throws MarsRoverException {
		when(heading.toChar()).thenReturn('N');

		position.step();

		verify(yAxis).increment();
	}

	@Test
	public void shouldPerformStepHeadingSouth() throws MarsRoverException {
		when(heading.toChar()).thenReturn('S');

		position.step();

		verify(yAxis).decrement();
	}

	@Test
	public void shouldPerformStepHeadingEast() throws MarsRoverException {
		when(heading.toChar()).thenReturn('E');

		position.step();

		verify(xAxis).increment();
	}

	@Test
	public void shouldPerformStepHeadingWest() throws MarsRoverException {
		when(heading.toChar()).thenReturn('W');

		position.step();

		verify(xAxis).decrement();
	}
}
