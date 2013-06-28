package com.mulesoft.rovers;

import com.mulesoft.rovers.exceptions.MarsRoverException;
import com.mulesoft.rovers.exceptions.UnrecognizedInstructionException;

public class MarsRover {

	private final Position currentPosition;

	public MarsRover(final Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Position processInstructions(final String instructions) throws MarsRoverException {
		char[] instructionArray = instructions.toCharArray();
		for (char instruction : instructionArray) {
			switch(instruction) {
			case 'L':
				currentPosition.getHeading().turnLeft();
				break;
			case 'R':
				currentPosition.getHeading().turnRight();
				break;
			case 'M':
				currentPosition.step();
				break;
			default:
				throw new UnrecognizedInstructionException();
			}
		}
		return currentPosition;
	}
}
