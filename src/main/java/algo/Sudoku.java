package algo;

public class Sudoku {

	static int n = 9;

	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		int a[][] = new int[][] { { 7, 8, 0, 4, 0, 0, 1, 2, 0 }, { 6, 0, 0, 0, 7, 5, 0, 0, 9 },
				{ 0, 0, 0, 6, 0, 1, 0, 7, 8 }, { 0, 0, 7, 0, 4, 0, 2, 6, 0 }, { 0, 0, 1, 0, 5, 0, 9, 3, 0 },
				{ 9, 0, 4, 0, 6, 0, 0, 0, 5 }, { 0, 7, 0, 3, 0, 0, 0, 1, 2 }, { 1, 2, 0, 0, 0, 7, 4, 0, 0 },
				{ 0, 4, 9, 2, 0, 6, 0, 0, 7 } };
//		initial sudoku
//		7 8 0 4 0 0 1 2 0 
//		6 0 0 0 7 5 0 0 9 
//		0 0 0 6 0 1 0 7 8 
//		0 0 7 0 4 0 2 6 0 
//		0 0 1 0 5 0 9 3 0 
//		9 0 4 0 6 0 0 0 5 
//		0 7 0 3 0 0 0 1 2 
//		1 2 0 0 0 7 4 0 0 
//		0 4 9 2 0 6 0 0 7 

		addSudokuValue(a, 0, 0);
		printMatrix(a);

		System.out.println("time taken in millisec: " + (System.currentTimeMillis() - time));
	}

	private static boolean addSudokuValue(int[][] a, int i, int j) {

		if (j == n) {
			j = 0;
			i += 1;
		}
		if (i >= 9) {
			System.out.println("final ending");
			return true;
		}
		if (a[i][j] != 0) {
			return addSudokuValue(a, i, j + 1);
		}
		for (int k = 1; k <= n; k++) {
			if (isValid(a, k, i, j)) {
				a[i][j] = k;
				if (addSudokuValue(a, i, j + 1)) {
					System.out.println("ending");
					return true;
				}
			}
		}
		a[i][j] = 0;
		return false;
	}

	static boolean isValid(int[][] a, int value, int row, int col) {
//		System.out.println("row :" + row + ", col:" + col + ", val :" + value);
		// validate row
		for (int i = 0; i < n; i++) {
			if (a[row][i] == value) {
//				System.out.println("row not valid");
				return false;
			}
		}
		// validate column
		for (int i = 0; i < n; i++) {
			if (a[i][col] == value) {
//				System.out.println("column not valid");
				return false;
			}
		}
		// validate box
		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;
		for (int i = rowStart; i < rowStart + 3; i++) {
			for (int j = colStart; j < colStart + 3; j++) {
				if (a[i][j] == value) {
//					System.out.println("box not valid");
					return false;
				}
			}
		}
		return true;
	}

	static void printMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
				if (a[i][j] != 0) {
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	static void addSudokuValueTest(int[][] a, int k, int i, int j, boolean[][] modify) {
		if (i == 9) {
			return;
		}
		printMatrix(a);
		if (isValid(a, k, i, j)) {
			a[i][j] = k;
			do {
				j++;
				if (j == 9) {
					i++;
					j = 0;
				}
			} while (i < 9 && !modify[i][j]);
			addSudokuValueTest(a, 1, i, j, modify);
			System.out.println("success");
		} else {
			if (k < 9) {
				addSudokuValueTest(a, k + 1, i, j, modify);
			} else {
				return;
			}
			System.out.println("fail case");
		}
	}
}
