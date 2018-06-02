package org.mackenzine.matrix;

public class Position {

	private int row;
	private int column;
	private int limit;

	public Position(final int row, final int column, final int limit) {
		this.row = row;
		this.column = column;
		this.limit = limit;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getLimit() {
		return limit;
	}

	public void setColumn(final int value) {
		column = value;
	}

	public void setRow(final int value) {
		row = value;
	}

	public void setLimit(final int value) {
		limit = value;
	}

}
