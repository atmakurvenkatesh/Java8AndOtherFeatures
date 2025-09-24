package algo;

import java.util.Arrays;

public class Nqueens {
	int n = 6;
	int[][] mat = new int[n][n];

	boolean nQueensAlgo(int row, int col) {
		if (row == n) {
			return true;
		}
		System.out.println("nQueensAlgo: " + row + " " + col);
		for (int j = col; j < n; j++) {
			if (isSafePosition(row, j)) {
				mat[row][j] = 1;
				printMatrix();
				if (nQueensAlgo(row + 1, 0)) {
					return true;
				} else {
					mat[row][j] = 0;
				}

			}
		}
		return false;
	}

	boolean isSafePosition(int row, int col) {
//		System.out.println("isSafePosition:");
		for (int i = 0; i < n; i++) {
			// row check
			if (mat[row][i] == 1) {
				return false;
			}
			// col check
			if (mat[i][col] == 1) {
				return false;
			}
		}
		// left top
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 1) {
				return false;
			}
		}
		// right bottom
		for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
			if (mat[i][j] == 1) {
				return false;
			}
		}
		// left bottom
		for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
			if (mat[i][j] == 1) {
				return false;
			}
		}
		// right top
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (mat[i][j] == 1) {
				return false;
			}
		}
		System.out.println("isSafePosition:true->" + row + " " + col);
		return true;
	}

	void printMatrix() {
		for (int[] i : mat) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Nqueens s = new Nqueens();
		s.nQueensAlgo(0, 0);
	}

}
