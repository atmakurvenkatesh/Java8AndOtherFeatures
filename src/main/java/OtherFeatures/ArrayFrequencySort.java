package OtherFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ArrayFrequencySort {
	public void frequencySort(Integer[] nums) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (Integer i : nums) {
			m.put(i, m.getOrDefault(i, 0) + 1);
		}
//		System.out.println(m);
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int diff = m.get(o1) - m.get(o2);
				if (diff == 0) {
					return o1 - o2;
				}
				return diff;
			}

		});
//		Arrays.stream(nums).forEach(System.out::println);
		System.out.println(Arrays.toString(nums));

	}

	public static void main(String[] args) {
		ArrayFrequencySort s = new ArrayFrequencySort();
		int[] a = new int[] { 1, 2, 5, 1, 4, 2, 5, 5, 9, 9 };
		s.frequencySort(Arrays.stream(a).boxed().toArray(Integer[]::new));

		List<Integer> sol = new ArrayList<>();
		Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().sorted(Map.Entry.comparingByValue()).forEach(e -> {
					for (int i = 0; i < e.getValue(); i++) {
						sol.add(e.getKey());
					}
				});
		System.out.println(sol.toString());
	}

}