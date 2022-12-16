package src;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("Enter a number: -->");
		int number = scanner.nextInt();
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= number; j++) {
				System.out.println(i + " X " + j + " = " + (i * j));

			}

		}
		System.out.println("Man Cannot be lesbian");
	}

}
