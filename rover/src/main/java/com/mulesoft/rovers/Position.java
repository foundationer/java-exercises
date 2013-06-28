package com.mulesoft.rovers;

import com.mulesoft.rovers.exceptions.HeadingException;
import com.mulesoft.rovers.exceptions.MarsRoverException;

public class Position {

	private final Heading heading;
	private final BoundedAxis xAxis;
	private final BoundedAxis yAxis;

	public Position(final BoundedAxis xAxis, final BoundedAxis yAxis, final Heading heading) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.heading = heading;
	}

	public int getxAxis() {
		return xAxis.getValue();
	}

	public int getyAxis() {
		return yAxis.getValue();
	}

	public Heading getHeading() {
		return heading;
	}

	public void step() throws MarsRoverException {
		char direction = heading.toChar();
		switch(direction) {
		case 'N':
			yAxis.increment();
			break;
		case 'E':
			xAxis.increment();
			break;
		case 'W':
			xAxis.decrement();
			break;
		case 'S':
			yAxis.decrement();
			break;
		default:
			throw new HeadingException("Cannot perform step");
		}
	}

	@Override
	public String toString() {
		return xAxis.getValue() + " " + yAxis.getValue() + " " + heading.toChar();
	}
}
