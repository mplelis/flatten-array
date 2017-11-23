package com.flattenarrays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.flattenarrays.FlattenArrayProcessor;

public class TestFlattenArrayProcessor {

	private Object[] integerArrayExpected = new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	private Object[] stringArrayExpected = new Object[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };

	private Object[] doubleArrayExpected = new Object[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10. };

	private FlattenArrayProcessor<? extends Object> flattenArrayProcessor;

	@Before
	public void setUp() {
		flattenArrayProcessor = new FlattenArrayProcessor<>();
	}

	@Test
	public void testIntegerArrayWithNestedArrays() {
		Object[] inputIntegerArray = new Object[]{1, new Object[]{2, 3}, 4, new Object[]{5, new Object[]{6, 7, new Object[]{8}}, 9}, 10};
		Object[] integerArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputIntegerArray);
		assertEquals(integerArrayExpected, integerArrayReturned);
	}
	
	@Test
	public void testIntegerFlatArray() {
		Object[] inputIntegerArray = new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Object[] integerArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputIntegerArray);
		assertEquals(integerArrayExpected, integerArrayReturned);
	}
	
	@Test
	public void testStringArrayWithNestedArrays() {
		Object[] inputStringArray = new Object[]{"a", new Object[]{"b", "c"}, "d", new Object[]{"e", new Object[]{"f", "g", new Object[]{"h"}}, "i"}, "j"};
		Object[] stringArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputStringArray);
		assertEquals(stringArrayExpected, stringArrayReturned);
	}
	
	@Test
	public void testStringFlatArray() {
		Object[] inputStringArray =  new Object[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		Object[] stringArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputStringArray);
		assertEquals(stringArrayExpected, stringArrayReturned);
	}
	
	@Test
	public void testDoubleArrayWithNestedArrays() {
		Object[] inputDoubleArray = new Object[]{1.1, new Object[]{2.2, 3.3}, 4.4, new Object[]{5.5, new Object[]{6.6, 7.7, new Object[]{8.8}}, 9.9}, 10.};
		Object[] doubleArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputDoubleArray);
		assertEquals(doubleArrayExpected, doubleArrayReturned);
	}
	
	@Test
	public void testDoubleFlatArray() {
		Object[] inputDoubleArray = new Object[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10. };
		Object[] doubleArrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputDoubleArray);
		assertEquals(doubleArrayExpected, doubleArrayReturned);
	}
	
	@Test
	public void testEmptyArrayShouldReturnEmptyArray() {
		Object[] inputArray = new Object[] {};
		Object[] arrayExpected = new Object[0];
		Object[] arrayReturned = flattenArrayProcessor.flattenAndReturnArray(inputArray);
		assertEquals(arrayExpected, arrayReturned);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNullArrayShouldThrowIllegalArgumentException() {
		Object[] inputArray = null;
		flattenArrayProcessor.flattenAndReturnArray(inputArray);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testArrayWithMultipleObjectTypesShouldThrowIllegalArgumentException() {
		Object[] inputArray = new Object[] { 1, "b", 3, new Object(), 5, 6.6, 7, 8, 9 ,10 };
		flattenArrayProcessor.flattenAndReturnArray(inputArray);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testArrayWithNullValueShouldThrowIllegalArgumentException() {
		Object[] inputArray = new Object[] { 1, null, 3, 4, 5, 6, 7, 8, 9 ,10 };
		flattenArrayProcessor.flattenAndReturnArray(inputArray);
	}
}
