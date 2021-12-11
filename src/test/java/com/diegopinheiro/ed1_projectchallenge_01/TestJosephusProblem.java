package com.diegopinheiro.ed1_projectchallenge_01;

import org.junit.Assert;
import org.junit.Test;

public class TestJosephusProblem {

	@Test
	public void testJosephusProblem2And7() {
		int n = 7;
		int m = 2;
		Integer[] actual = JosephusProblem.solve(m, n);
		Integer[] expected = { 1, 3, 5, 0, 4, 2, 6 };
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testJosephusProblem4And7() {
		int n = 7;
		int m = 4;
		Integer[] actual = JosephusProblem.solve(m, n);
		Integer[] expected = { 3, 0, 5, 4, 6, 2, 1 };
		Assert.assertArrayEquals(expected, actual);
	}
}
