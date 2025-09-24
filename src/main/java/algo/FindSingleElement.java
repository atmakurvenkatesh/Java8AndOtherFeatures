package algo;

public class FindSingleElement {

	public static int findSingleElement(int[] numbers) {
		boolean adjacent = false;
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				adjacent = true; // marking element has same adjacent value
			} else {
				if (adjacent != true) { // both previous and next element is not same
					return numbers[i];
				} else { // previous element is same but not next element
					adjacent = false;
				}
			}
		}
		// handling for last element
		if (numbers[n - 1] != numbers[n - 2]) {
			return numbers[n - 1];
		}
		return -1;
	}

	public static void search(int[] arr, int low, int high) {
		System.out.println(arr + " " + low + "," + high);
		if (low > high)
			return;
		if (low == high) {
			System.out.println("The required element is " + arr[low]);
			return;
		}

		// Find the middle point
		int mid = (low + high) / 2;

		// If mid is even and element next to mid is
		// same as mid, then output element lies on
		// right side, else on left side
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1])
				search(arr, mid + 2, high);
			else
				search(arr, low, mid);
		}
		// If mid is odd
		else if (mid % 2 == 1) {
			if (arr[mid] == arr[mid - 1])
				search(arr, mid + 1, high);
			else
				search(arr, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1, 1, 3, 3, 4, 4, 5, 5, 6, 6, 8, 9, 9 };
//		System.out.println(findSingleElement(a));
		search(a, 0, a.length - 1);
		a = new int[] { 1, 3, 3, 3, 4, 4, 5, 5, 6, 6, 9, 9, 9 };
		search(a, 0, a.length - 1);

	}
}
