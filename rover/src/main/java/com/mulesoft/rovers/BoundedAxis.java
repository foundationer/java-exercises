package com.mulesoft.rovers;

import com.mulesoft.rovers.exceptions.GridOutOfBoundsException;

public class BoundedAxis {

	private int value;
	private final int limit;

	public BoundedAxis(final int value, final int limit) throws GridOutOfBoundsException {
		this.value = value;
		if(limit > 0) {
			this.limit = limit;
		} else {
			throw new GridOutOfBoundsException();
		}
	}

	public void increment() throws GridOutOfBoundsException {
		if(value < limit) {
			value++;
		} else {
			throw new GridOutOfBoundsException();
		}
	}

	public void decrement() throws GridOutOfBoundsException {
		if(value > 0) {
			value--;
		} else {
			throw new GridOutOfBoundsException();
		}
	}

	public int getValue() {
		return value;
	}
}
