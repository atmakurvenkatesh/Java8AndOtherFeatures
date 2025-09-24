package algo;

public class MaxSquareMatrix {

	static int sol = 1;

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{ 1, 0, 1, 1, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1 }, 
			{ 0, 0, 1, 1, 1, 1 }, 
			{ 1, 0, 1, 1, 0, 1 },
			{ 1, 1, 1, 1, 1, 1 } };
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					checkDiagonal(matrix, i, j, m, n);
				}
			}
		}
		System.out.println(sol);
	}

	private static void checkDiagonal(int[][] matrix, int i, int j, int m, int n) {
		int curMax = 0;
		int inc = 0;
		while (inc < m && inc < n) {
			curMax += 1;
			inc += 1;
//			System.out.println("i-" + i + ",j-" + j + ",inc-" + inc + ",curMax-" + curMax + ",sol-" + sol);

			if (i + inc >= m || j + inc >= n || matrix[i + inc][j + inc] != 1) {
//				System.out.println("val failed");
				return;
			}
			for (int k = i; k <= i + inc; k++) {
				if (matrix[k][j + inc] != 1) {
//					System.out.println("col failed");
					return;
				}
			}
			for (int k = j; k <= j + inc; k++) {
				if (matrix[i + inc][k] != 1) {
//					System.out.println("row failed");
					return;
				}
			}
//			System.out.println("success");
			if (curMax+1 > sol) {
				sol = curMax+1;
			}
//			System.out.println("sol="+sol);
		}

	}
}
