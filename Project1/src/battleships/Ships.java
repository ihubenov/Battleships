package battleships;

import java.util.Random;

public class Ships {

	static boolean check(int posX, int posY, byte len, boolean vertical) {
		if (vertical) {
			for (int i = posY; i < posY + len; i++) {
				if (BattleField.array[posX][i].hasShip) {
					return false;
				}
			}
		} else {
			for (int i = posX; i < posX + len; i++) {
				if (BattleField.array[i][posY].hasShip) {
					return false;
				}
			}
		}

		return true;
	}

	public static void createShip(byte len) {
		Random rand = new Random();
		int posX, posY;
		boolean vertical;
		vertical = rand.nextBoolean();

		do {
			if (vertical) {
				posX = rand.nextInt(10);
				posY = rand.nextInt(10 - len);
			} else {
				posX = rand.nextInt(10 - len);
				posY = rand.nextInt(10);
			}

		} while (!check(posX, posY, len, vertical));

		if (vertical) {
			for (int i = posY; i < (posY + len); i++) {
				BattleField.array[posX][i].hasShip = true;
			}
		} else {
			for (int i = posX; i < (posX + len); i++) {
				BattleField.array[i][posY].hasShip = true;
			}
		}

	}

}
