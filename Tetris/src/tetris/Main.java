package tetris;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner mapInput = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		ArrayList<Integer> diamonds = new ArrayList<Integer>();
		tetrisDiamonds(map, 15, 10);
		tetrisDiamonds(diamonds, 4, 4);
		int loca = mapInput.nextInt() - 1;
		detection(map, diamonds, loca);

		mapInput.close();
	}

	private static void detection(ArrayList<Integer> map, ArrayList<Integer> diamonds, int loca) {
		int[] indexCoulumn = new int[4];
		int[] indexRow = new int[4];
		int i = 0;
		int mapIndexRow = 0;
		int mapIndexRow1 = 15;
		int index = 0;
		int diff = 0;
		for (i = 0; i < 4; i++) {
			if ((diamonds.indexOf(1) + 1) % 4 != 0) {
				indexCoulumn[i] = loca + ((diamonds.indexOf(1) + 1) % 4);
			} else {
				indexCoulumn[i] = loca + 4;
			}

			if ((diamonds.indexOf(1) + 1) % 4 != 0) {
				indexRow[i] = 1 + (diamonds.indexOf(1) + 1) / 4;
			} else {
				indexRow[i] = (diamonds.indexOf(1) + 1) / 4;
			}

			while (map.get((mapIndexRow * 10 + indexCoulumn[i]) - 1) != 1) {
				mapIndexRow++;
				if (mapIndexRow == 15)
					break;
			}

			if (mapIndexRow < 5) {
				System.out.println("error");
			}
			
			if (mapIndexRow <= mapIndexRow1) {
				mapIndexRow1 = mapIndexRow;
				index = i;
			}
			mapIndexRow = 0;
			diamonds.set(diamonds.indexOf(1), 2);
		}
// -------------避免一种特殊情况下会出现的错误：即竖着的L形方块，可能最先碰到的是最下面的小块而非最上面拐出来的小块-----------

		diff = mapIndexRow1 - indexRow[index];
		if (indexRow[0] == indexRow[1] && indexRow[0] < indexRow[2] && indexCoulumn[2] == indexCoulumn[3]) {
			while (map.get((mapIndexRow * 10 + indexCoulumn[2]) - 1) != 1) {
				mapIndexRow++;
				if (mapIndexRow == 15)
					break;
			}
			if (mapIndexRow - indexRow[3] - mapIndexRow1 + indexRow[index] < 1) {
				diff = mapIndexRow - indexRow[3];
			}
		}
// ----------------------------------------------------------------------------------------------
		for (i = 0; i < 4; i++) {
			map.set((indexRow[i] + diff - 1) * 10 + indexCoulumn[i] - 1, 1);
		}
		for (i = 0; i < map.size(); i++) {
			System.out.print(map.get(i) + " ");
			if ((i + 1) % 10 == 0) {
				System.out.print("\n");
			}
		}
	}

	private static void tetrisDiamonds(ArrayList<Integer> diamonds, int row, int column) {
		int mapNum = row * column, i;

		try {
			for (i = 0; i < mapNum; i++) {
				int aDiamonds = mapInput.nextInt();
				diamonds.add(aDiamonds);
			}

		} catch (Exception e) {
			System.out.println("error");
		}
	}

}
