package battleships;

import java.util.Scanner;

public class Play {

	static void createShips() {
		Ships.createShip((byte) 4);
		Ships.createShip((byte) 4);
		Ships.createShip((byte) 5);
	}

	public static void main(String[] args) {
		int p;
		Scanner scanner = new Scanner(System.in);
		String input;
		int hitCount = 0, missCount = 0;

		createShips();

		while (hitCount != 13) {

			BattleField.print();

			System.out.println("input: ");
			input = scanner.nextLine();

			switch (input.length()) {
			case 4:

				if (input.equalsIgnoreCase("show")) {
					BattleField.show();
					scanner.next();
					break;
				} else {
					System.out.println("Wrong input!");
					break;
				}

			case 2:
			case 3:

				char c;

				if (input.charAt(0) >= 'a' && input.charAt(0) <= 'j') {
					input = input.replace(input.charAt(0),
							(char) (input.charAt(0) - ('a' - 'A')));
				}
				if (input.charAt(0) >= 'A' && input.charAt(0) <= 'J') {
					try {
						p = Integer.parseInt(input.substring(1));
					} catch (Exception e) {
						System.out.println("Wrong input!");
						break;
					}

					if (p > 10 || p < 1) {
						System.out.println("Wrong input! ");
						break;
					}

					int k = input.charAt(0) - 'A';

					if (BattleField.array[k][p - 1].isHit == false) {
						BattleField.array[k][p - 1].isHit = true;

						if (BattleField.array[k][p - 1].hasShip) {
							hitCount++;
						} else {
							missCount++;
						}
					} else {
						System.out.println("Already hit that one!");
					}
					break;
				}

			default:
				System.out.println("Wrong input!");
				continue;

			}
		}
		scanner.close();

		BattleField.print();

		System.out.println("Congratulations! Victory in "
				+ (hitCount + missCount) + " hits!");
	}
}
