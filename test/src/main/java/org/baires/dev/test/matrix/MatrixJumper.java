package org.baires.dev.test.matrix;

public class MatrixJumper {

	private final char[][] matrix;
	private final Position current;
	private char temp;

	public MatrixJumper(final char[][] matrix, final Position start) {
		this.matrix = matrix;
		this.current = start;
	}

	public char jumpRight(final int step, final char value) {
		int limit = current.getLimit();
		int column = current.getColumn();

		if(step <= limit - column) {
			current.setColumn(column + step);
		} else {
			current.setRow(column + (step - limit));
			current.setColumn(limit);
		}
		update(value);
		return temp;
	}

	public char jumpDown(final int step, final char value) {
		int limit = current.getLimit();
		int row = current.getRow();

		if(step <= limit - row) {
			current.setRow(row + step);
		} else {
			current.setRow(limit);
			current.setColumn(step - row);
		}
		update(value);
		return temp;
	}

	public char jumpLeft(final int step, final char value) {
		int column = current.getColumn();
		int limit = current.getLimit();

		if(column < step) {
			current.setRow(limit - (step - column));
			current.setColumn(0);
		} else {
			current.setColumn(column - step);
		}
		update(value);
		return temp;
	}

	public char jumpUp(final int step, final char value) {
		int row = current.getRow();

		if(row < step) {
			current.setRow(0);
			current.setColumn(step - row);
		} else {
			current.setRow(row - step);
		}
		update(value);
		return temp;
	}

	public Position getCurrentPosition() {
		return current;
	}

	public void prepareNextStep() {
		current.setColumn(current.getColumn() + 1);
	}

	public void prepareSubMatrix(final int index) {
		if(current.getColumn() <= current.getLimit()) {
			current.setColumn(index);
			current.setRow(index);
			current.setLimit(current.getLimit() - 1);
		}
	}

	private void update(final char value) {
		int newRow = current.getRow();
		int newColumn = current.getColumn();
		temp = matrix[newRow][newColumn];
		matrix[newRow][newColumn] = value;
	}
}
