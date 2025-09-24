package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PondsCount2UsingQueue {

	public static void main(String[] args) {

	}

	public static List<Integer> riverSizes(int[][] matrix) {
		// Write your code here.
		int length = matrix.length;
		int breadth = matrix[0].length;
		List<Integer> response = new ArrayList<>();
		int sizeOfRivers = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				if (matrix[i][j] == 0 || matrix[i][j] == -1) {
					continue;
				}
				sizeOfRivers = getSizeOfRiver(i, j, matrix);
				response.add(sizeOfRivers);
			}
		}
		return response;
	}

	public static int getSizeOfRiver(int currI, int currJ, int[][] matrix) {
		int size = 0;
		Queue<RowKeys> queue = new LinkedList<>();
		queue.offer(new RowKeys(currI, currJ));
		while (!queue.isEmpty()) {

			RowKeys currRow = queue.poll();
			size++;
			matrix[currRow.row][currRow.col] = -1;
			if (currRow.row > 0 && matrix[currRow.row - 1][currRow.col] == 1) {
				queue.offer(new RowKeys(currRow.row - 1, currRow.col));
			}
			if (currRow.col > 0 && matrix[currRow.row][currRow.col - 1] == 1) {
				queue.offer(new RowKeys(currRow.row, currRow.col - 1));
			}
			if (currRow.row < matrix.length - 1 && matrix[currRow.row + 1][currRow.col] == 1) {
				queue.offer(new RowKeys(currRow.row + 1, currRow.col));
			}
			if (currRow.col < matrix[0].length - 1 && matrix[currRow.row][currRow.col + 1] == 1) {
				queue.offer(new RowKeys(currRow.row, currRow.col + 1));
			}
		}
		return size;
	}

	static class RowKeys {
		int row;
		int col;

		RowKeys(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}
}