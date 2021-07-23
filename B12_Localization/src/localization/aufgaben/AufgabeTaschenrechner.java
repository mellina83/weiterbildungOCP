package localization.aufgaben;

import java.util.Scanner;

import localization.aufgaben.Operation;

public class AufgabeTaschenrechner {

	/**
	 * Bitte i18n durchführen und dann l10n für de und en einpflegen.
	 */
	public static void main(String[] args) {
		char yesChar = 'y';
		char repeat = yesChar;
		while (repeat == yesChar) {
			System.out.print("1st number:");
			double a = readUserNumber();

			System.out.print("Operator : " + " (+, -, *, /):");
			char operator = readUserChar();

			System.out.print("2nd number:");
			double b = readUserNumber();

			Operation op = null;

			switch (operator) {
				case '+':
					op = (n1, n2) -> n1 + n2;
					break;
				case '-':
					op = (n1, n2) -> n1 - n2;
					break;
				case '*':
					op = (n1, n2) -> n1 * n2;
					break;
				case '/':
					op = (n1, n2) -> n1 / n2;
					break;

				default:
					System.out.println("Error! Operator not supported:" + " " + operator);
					continue; // wieder von vorne
			}

			double result = op.execute(a, b);
			System.out.println("Result:" + " " + result);

			System.out.print("Once more? (y/n):");
			repeat = readUserChar();
		}

	}

	@SuppressWarnings("resource")
	private static double readUserNumber() {
		return new Scanner(System.in).nextDouble();
	}

	@SuppressWarnings("resource")
	private static char readUserChar() {
		return new Scanner(System.in).nextLine().charAt(0);
	}
}
