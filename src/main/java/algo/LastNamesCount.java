package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LastNamesCount {

//	ram tiwari ,shayam manohar ,mona tiwari ,radha tiwari ,sunder lodh , john manohar
//	output: tiwari-3 , manohar -2, lodh-1
	public static void main(String[] args) {
		List<String> s = Arrays
				.asList("ram tiwari,shayam manohar,mona tiwari ,radha tiwari ,sunder lodh, john manohar".split(","));
//		s.forEach(i -> System.out.println(i.trim()));
//		namesCount(s);
		namesCountUsingStreams(s);
	}

	public static void namesCountUsingStreams(List<String> fullNames) {
		System.out.println(fullNames.stream().map(i -> i.trim().split(" ")[1])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

	public static void namesCount(List<String> fullNames) {
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < fullNames.size(); i++) {
			String lastname = fullNames.get(i).trim().split(" ")[1];
			if (m.containsKey(lastname)) {
				m.put(lastname, m.get(lastname) + 1);
			} else {
				m.put(lastname, 1);
			}
		}
		for (String i : m.keySet()) {
			System.out.print(i + "-" + m.get(i) + " , ");
		}
	}

}
