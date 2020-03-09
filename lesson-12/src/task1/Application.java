package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import task1.Car;

public class Application {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int min = 0;
		int max = 0;
		int choice = 0;
		int size;
		String[] material = { "leather", "alcantara" };

		System.out.println("Enter two numbers which will determine the range of a random size of an array: ");

		try {
			min = scan.nextInt();
			max = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Wrong input...");
			e.printStackTrace();
		}

		size = getRandomValue(min, max);
		ArrayList<Car> cars=new ArrayList<>();

		while (true) {
			System.out.println("Enter a num of your choice: ");
			System.out.println("1. To fill and print the properties of random cars; ");
			System.out.println("2. To fill all the cars with the properties by default and print them");

			try {
				choice = scan.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Wrong input...");
				e.printStackTrace();
				break;
			}

			switch (choice) {
			case 1: {
				if(!cars.isEmpty()) {
					cars.clear();
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						cars.add(new Car(getRandomValue(140, 200), getRandomValue(2000, 2020),
								(new Engine(getRandomValue(32, 38), (material[getRandomValue(0, 1)]))),
								(new Helm(getRandomValue(8, 14)))));
					}
				}

				System.out.println(cars);
				break;
			}
			case 2: {
				if(!cars.isEmpty()) {
					cars.clear();
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
					cars.add(new Car(200, 2016, new Engine(36, "leather"), new Helm(12)));
					}
				}

				System.out.println(cars);
			}
				break;
			}

		}

	}

	public static int getRandomValue(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Min value must be smaller than max");
		}
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

}
