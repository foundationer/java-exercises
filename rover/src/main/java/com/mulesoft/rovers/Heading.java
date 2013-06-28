package com.mulesoft.rovers;

import com.mulesoft.rovers.exceptions.HeadingException;

public class Heading {

	private final static char[] direction = new char[] { 'N', 'E', 'S', 'W' };
	private int currentIndex = -1;

	public Heading(final char start) throws HeadingException {
		for(int i=0; i < direction.length; i++) {
			if(start == direction[i]) {
				currentIndex = i;
			}
		}
		if(currentIndex < 0) {
			throw new HeadingException("Wrong heading");
		}
	}

	public char turnLeft() {
		if(currentIndex == 0) {
			currentIndex = 3;
		} else {
			currentIndex = (currentIndex - 1) % 4;
		}
		return this.toChar();
	}

	public char turnRight() {
		currentIndex = (currentIndex + 1) % 4;
		return this.toChar();
	}

	public char toChar() {
		return direction[currentIndex];
	}
}
