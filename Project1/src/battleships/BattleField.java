package battleships;

public abstract class BattleField {

	static class Field {
		boolean isHit;
		boolean hasShip;

		public Field() {
			isHit = false;
			hasShip = false;
		}
	}

	static Field[][] array;

	static {
		array = new Field[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				array[i][j] = new Field();
			}
		}

	}

	static void print() {
		System.out.print("  ");

		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + " ");
		}

		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.print((char) ('A' + i) + " ");

			for (int j = 0; j < 10; j++) {
				if (array[i][j].isHit == false) {
					System.out.print(". ");
				} else if (array[i][j].hasShip == true) {
					System.out.print("x ");
				} else {
					System.out.print("- ");
				}
			}

			System.out.println();
		}
	}

	static void show() {
		System.out.print("  ");

		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + " ");
		}

		System.out.println();

		for (int i = 0; i < 10; i++) {

			System.out.print((char) ('A' + i) + " ");

			for (int j = 0; j < 10; j++) {
				if (array[i][j].hasShip == true) {
					System.out.print("x ");
				} else {
					System.out.print("  ");
				}
			}

			System.out.println();
		}
	}

}
