package algo;

public class PondsCount {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int[][] matrix = new int[][] { 
			{ 1, 0, 1, 1, 0 }, 
			{ 1, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 0, 1 }, 
			{ 1, 0, 1, 0, 1 },
			{ 1, 1, 0, 1, 0 } };

		int matrixRowLength = matrix.length;
		int matrixColLength = matrix[0].length;
		int[][] visited = new int[matrixRowLength][matrixColLength];
		for (int i = 0; i < matrixRowLength; i++) {
			for (int j = 0; j < matrixColLength; j++) {
				int tot = getCounts(matrix, visited, i, j, matrixRowLength, matrixColLength);
				if (tot > 0) {
					System.out.println(tot);
				}
			}
		}
		System.out.println("Time taken: " + (System.currentTimeMillis() - time));
	}

	public static int getCounts(int[][] matrix, int[][] visited, int curRow, int curCol, int matrixRowLength,
			int matrixColLength) {
		int t = 0;
		if (visited[curRow][curCol] == 0 && matrix[curRow][curCol] == 1) {
			visited[curRow][curCol] = 1;
			t += 1;
			if (curRow != matrixRowLength - 1) {
				t += getCounts(matrix, visited, curRow + 1, curCol, matrixRowLength, matrixColLength);
			}
			if (curRow > 0) {
				t += getCounts(matrix, visited, curRow - 1, curCol, matrixRowLength, matrixColLength);
			}
			if (curCol != matrixColLength - 1) {
				t += getCounts(matrix, visited, curRow, curCol + 1, matrixRowLength, matrixColLength);
			}
			if (curCol > 0) {
				t += getCounts(matrix, visited, curRow, curCol - 1, matrixRowLength, matrixColLength);
			}
		}
//		System.out.print(r + " " + c + "==");
//		System.out.println(t);
//		System.out.println("=============");
		return t;
	}
}
