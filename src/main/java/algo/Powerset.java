package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {
	public static void main(String[] args) {
//		Solution s = new Solution();
//		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
		backTrackPowerset s = new backTrackPowerset();
		System.out.println(s.powerset(Arrays.asList(1, 2, 3)));
	}

}

// using normal iterative approach
class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sol = new ArrayList<List<Integer>>();
		sol.add(new ArrayList<Integer>());
		for (int i : nums) {
			int size = sol.size();
			for (int itr = 0; itr < size; itr++) {
				ArrayList<Integer> li = new ArrayList<Integer>(sol.get(itr));
				li.add(i);
				sol.add(li);
			}
			System.out.println("sol:" + sol);
		}
		return sol;
	}
}

// using recursion
class RecursionPowerset {
	public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output.add(new ArrayList<>());
		helper(array, output);
		return output;
	}

	public static void helper(List<Integer> array, List<List<Integer>> output) {
		if (array.size() == 0)
			return;
		Integer ele = array.get(0);
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		for (List<Integer> arr : output) {
			List<Integer> arr1 = new ArrayList<>(arr);
			arr1.add(ele);
			tmp.add(arr1);
		}
		output.addAll(tmp);
		array.remove(ele);
		helper(array, output);
	}
}

// using backtrack
class backTrackPowerset {
	public List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output.add(new ArrayList<>());
		helper(array, new ArrayList<Integer>(), output, 0);
		return output;
	}

	private void helper(List<Integer> array, ArrayList<Integer> temp, List<List<Integer>> output, int index) {
		if (!temp.isEmpty()) {
			output.add(new ArrayList<Integer>(temp));
		}
		System.out.println(temp);
		for (int i = index; i < array.size(); i++) {
			temp.add(array.get(i));
			helper(array, temp, output, i + 1);
			// remove the added element for backtrack
			temp.remove(array.get(i));
//			temp.remove(temp.size() - 1);
		}
	}
}
