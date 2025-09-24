package algo;

public class SpiralPrintOfMatrix {

	private static void printSpiral(int[][] m) {
		int left = 0, bottom = 0, right = 0, top = 0, i = 0, j = 0;
		bottom = m.length;
		right = m[0].length;

		while (top < bottom && left < right) {
			while (j < right) {
				System.out.print(m[i][j] + " ");
				j++;
			}
			j--;
			i++;
			while (i < bottom) {
				System.out.print(m[i][j] + " ");
				i++;
			}
			j--;
			i--;
			while (j >= left) {
				System.out.print(m[i][j] + " ");
				j--;
			}
			j++;
			i--;
			while (i > top) {
				System.out.print(m[i][j] + " ");
				i--;
			}
			i++;
			j++;
			top++;
			bottom--;
			left++;
			right--;
		}

	}

	public static void main(String[] args) {
		int[][] m = new int[][] { 
			{ 1, 2, 3, 4, 5 }, 
			{ 6, 7, 8, 9, 10 }, 
			{ 11, 12, 13, 14, 15 },
//			{ 16, 17, 18, 19, 20 } ,
//			{ 21, 22, 23, 24, 25}
			};
		printSpiral(m);
	}

}

// 1   2   3   4   5
// 6   7   8   9   10
//11  12  13  14   15
//16  17  18  19   20