package task3;

import java.util.Arrays;

public class Arraylist {

	private int size = 10;
	private Object[] array = new Object[size];
	int lastElement = 0;

	public void add(Object element) {
		if (lastElement == array.length - 1) {
			Object[] newArray = new Object[array.length * (3 / 2) + 1];

			for (int i = 0; i < lastElement; i++) {
				newArray[i] = array[i];
			}

			array = newArray;
		}
		array[lastElement++] = element;
	}

	public void print() {
		for (Object obj : array) {
			System.out.print(obj + " ");
		}
	}

	public void remove(int index) {
		
		if (array[index] == null) {
			System.err.println("There is no element at this position...");
		}
		
		if (index >= array.length) {
			throw new ArrayIndexOutOfBoundsException("You are out of the bound of the array");
		}
		
		Object[] newArray = new Object[array.length - 1];
		
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}
		
		for (int i = index; i < lastElement; i++) {
			newArray[i] = array[i + 1];
		}

		lastElement--;
		array = newArray;

	}

	@Override
	public String toString() {
		return "Arraylist [size=" + size + ", array=" + Arrays.toString(array) + ", lastElement=" + lastElement + "]";
	}

}
