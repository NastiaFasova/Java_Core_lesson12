package task3;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Arraylist list = new Arraylist();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		int index = 0;

		while (true) {
			System.out.println("Enter a number of your choice: ");
			System.out.println("1. To add an element into an ArrayList;");
			System.out.println("2. To remove an element from the ArrayList;");
			System.out.println("3. To print the content of an array;");

			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				System.err.println("Wrong input...");
				e.printStackTrace();
			}

			switch (choice) {
			case 1: {
				System.out.println("Enter a word, an integer or a double you would like to add: ");
				String str = scan.next();
				list.add(str);
				break;
			}
			case 2: {
				System.out.println("Enter an index of an element you would like to remove: ");

				try {
					index = scan.nextInt();
				} catch (Exception e) {
					System.err.println("Wrong input...");
					e.printStackTrace();
				}

				list.remove(index);
				break;
			}
			case 3: {
				System.out.println(list.toString());
				break;
			}
			}
			break;
		}

	}

}
