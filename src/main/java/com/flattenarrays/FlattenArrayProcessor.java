package com.flattenarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the ArrayProcessorStrategy which flattens an array of objects and nested arrays of 
 * objects of the same type and returns the relevant flattened array of Objects.
 * It can flatten arrays with objects of any type like Integer, Double or String.
 * @author Mihalis Plelis
 */
@SuppressWarnings("unchecked")
public class FlattenArrayProcessor<T> {

	public T[] flattenAndReturnArray(Object[] inputArray) {
		if (inputArray == null) {
			throw new IllegalArgumentException("Input Array should not be null.");
		}
		if (inputArray.length == 0) {
			return (T[]) new Object[0];
		}
		List<T> flattenedList = new ArrayList<>();
		Class<? extends Object> clas = inputArray[0].getClass();
		for (Object object : inputArray) {
			if (clas.isInstance(object)) {
				flattenedList.add((T) object);
			} else if (object instanceof Object[]) {
				flattenedList.addAll((Collection<T>) Arrays.asList(flattenAndReturnArray((T[]) object)));
			} else {
				throw new IllegalArgumentException(
						"Input array should be an array of elements of the same Type and nested Arrays of elements of the same Type.");
			}
		}
		return (T[]) flattenedList.toArray(new Object[0]);
	}

}
