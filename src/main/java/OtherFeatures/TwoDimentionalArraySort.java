package OtherFeatures;

import java.util.Arrays;

public class TwoDimentionalArraySort {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 3, 5, 7 }, 
				{ 6, 5, 4 }, 
				{ 3, 5, 6 },
				{ 8, 4, 1 },
				{ 5, 3, 4 },};

		System.out.println("sort by 3nd col:");
		// Sort rows based on the value in the second column (index 1)
		Arrays.sort(arr, (i, j) -> i[2] - j[2]);

		// Print sorted 2D array
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println("sort by all cols:");
		// Sort rows based on the value in the second column (index 1)
		Arrays.sort(arr, Arrays::compare);
		// Print sorted 2D array
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}

	}
}
