package org.baires.dev.test.matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MatrixRotatorTest {

	private MatrixRotator rotator;

	@Before
	public void setUp() {
		rotator = new MatrixRotator();
	}

	@Test
	public void shouldRotate3x3Matrix() {
		char[][] matrix = new char[3][3];
		matrix[0] = new char[] { 'a', 'b', 'c' };
		matrix[1] = new char[] { 'd', 'e', 'f' };
		matrix[2] = new char[] { 'g', 'h', 'i' };

		rotator.rotateMatrix(matrix);

		assertArrayEquals(new char[] { 'g', 'd', 'a' }, matrix[0]);
		assertArrayEquals(new char[] { 'h', 'e', 'b' }, matrix[1]);
		assertArrayEquals(new char[] { 'i', 'f', 'c' }, matrix[2]);
	}

	@Test
	public void shouldRotate2x2Matrix() {
		char[][] matrix = new char[2][2];
		matrix[0] = new char[] { 'a', 'b' };
		matrix[1] = new char[] { 'c', 'd' };

		rotator.rotateMatrix(matrix);

		assertArrayEquals(new char[] { 'c', 'a' }, matrix[0]);
		assertArrayEquals(new char[] { 'd', 'b' }, matrix[1]);
	}

	@Test
	public void shouldRotate4x4Matrix() {
		char[][] matrix = new char[4][4];
		matrix[0] = new char[] { 'a', 'b', 'c', 'd' };
		matrix[1] = new char[] { 'e', 'f', 'g', 'h' };
		matrix[2] = new char[] { 'i', 'j', 'k', 'l' };
		matrix[3] = new char[] { 'm', 'n', 'o', 'p' };

		rotator.rotateMatrix(matrix);

		assertArrayEquals(new char[] { 'm', 'i', 'e', 'a' }, matrix[0]);
		assertArrayEquals(new char[] { 'n', 'j', 'f', 'b' }, matrix[1]);
		assertArrayEquals(new char[] { 'o', 'k', 'g', 'c' }, matrix[2]);
		assertArrayEquals(new char[] { 'p', 'l', 'h', 'd' }, matrix[3]);
	}
}
