package org.mackenzine.matrix;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixJumperTest {

	private MatrixJumper jumper;
	private final char[][] matrix = new char[3][3];
	private int limit;

	@BeforeEach
	public void setUp() {
		matrix[0] = new char[] { 'a', 'b', 'c' };
		matrix[1] = new char[] { 'd', 'e', 'f' };
		matrix[2] = new char[] { 'g', 'h', 'i' };
		limit = matrix.length - 1;
	}

	@Test
	public void shouldJumpRight2StepsFrom00() {
		jumper = new MatrixJumper(matrix, new Position(0, 0, limit));

		char temp = jumper.jumpRight(2, matrix[0][0]);

		assertEquals('c', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(0, currentPosition.getRow());
		assertEquals(2, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[0][0], matrix[0][2]);
	}

	@Test
	public void shouldJumpRight2StepsFrom01() {
		jumper = new MatrixJumper(matrix, new Position(0, 1, limit));

		char temp = jumper.jumpRight(2, matrix[0][1]);

		assertEquals('f', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(1, currentPosition.getRow());
		assertEquals(2, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[0][1], matrix[1][2]);
	}

	@Test
	public void shouldJumpDown2StepsFrom02() {
		jumper = new MatrixJumper(matrix, new Position(0, 2, limit));

		char temp = jumper.jumpDown(2, matrix[0][2]);

		assertEquals('i', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(2, currentPosition.getRow());
		assertEquals(2, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[2][2], matrix[0][2]);
	}

	@Test
	public void shouldJumpDown2StepsFrom12() {
		jumper = new MatrixJumper(matrix, new Position(1, 2, limit));

		char temp = jumper.jumpDown(2, matrix[1][2]);

		assertEquals('h', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(2, currentPosition.getRow());
		assertEquals(1, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[1][2], matrix[2][1]);
	}

	@Test
	public void shouldJumpLeft2StepsFrom22() {
		jumper = new MatrixJumper(matrix, new Position(2, 2, limit));

		char temp = jumper.jumpLeft(2, matrix[2][2]);

		assertEquals('g', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(2, currentPosition.getRow());
		assertEquals(0, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[2][0], matrix[2][2]);
	}

	@Test
	public void shouldJumpLeft2StepsFrom21() {
		jumper = new MatrixJumper(matrix, new Position(2, 1, limit));

		char temp = jumper.jumpLeft(2, matrix[2][1]);

		assertEquals('d', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(1, currentPosition.getRow());
		assertEquals(0, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[1][0], matrix[2][1]);
	}

	@Test
	public void shouldJumpUp2StepsFrom20() {
		jumper = new MatrixJumper(matrix, new Position(2, 0, limit));

		char temp = jumper.jumpUp(2, matrix[2][0]);

		assertEquals('a', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(0, currentPosition.getRow());
		assertEquals(0, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[0][0], matrix[2][0]);
	}

	@Test
	public void shouldJumpUp2StepsFrom10() {
		jumper = new MatrixJumper(matrix, new Position(1, 0, limit));

		char temp = jumper.jumpUp(2, matrix[1][0]);

		assertEquals('b', temp);

		Position currentPosition = jumper.getCurrentPosition();

		assertEquals(0, currentPosition.getRow());
		assertEquals(1, currentPosition.getColumn());
		assertEquals(2, currentPosition.getLimit());

		assertEquals(matrix[0][1], matrix[1][0]);
	}
}
