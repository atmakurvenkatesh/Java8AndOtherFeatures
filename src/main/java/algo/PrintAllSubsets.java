package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllSubsets {

	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(1, 2, 3, 4);
		System.out.println(subset(l));

	}

	private static List<List<Integer>> subset(List<Integer> arr) {
		List<List<Integer>> finalList = new ArrayList<>();
		finalList.add(new ArrayList<Integer>());

		for (Integer i : arr) {
			List<List<Integer>> temp = new ArrayList<>();
			for (List<Integer> li : finalList) {
				List<Integer> temp2 = new ArrayList<Integer>(li);
				temp2.add(i);
				temp.add(temp2);
			}
			finalList.addAll(temp);
		}
		return finalList;
	}
}
