package org.mackenzine.matrix;

public class MatrixRotator {

	private MatrixJumper jumper;

	public void rotateMatrix(final char[][] matrix) {

		int limit = matrix.length - 1;
		jumper = new MatrixJumper(matrix, new Position(0, 0, limit));

		while(limit >= 0) {
			System.out.println("Processing " + (limit + 1) + " x " + (limit + 1) + " submatrix.");
			for(int i = 0; i < limit; i++) {
				Position current = jumper.getCurrentPosition();
				jumper.jumpUp(limit,
						jumper.jumpLeft(limit,
								jumper.jumpDown(limit,
										jumper.jumpRight(limit,
												matrix[current.getRow()][current.getColumn()]))));
				show(matrix);
				jumper.prepareNextStep();
			}
			limit-=2;
			jumper.prepareSubMatrix(limit);
		}
	}

	private void show(final char[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			System.out.print("[ ");
			for(int j=0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ]");
		}
		System.out.println();
	}
}
