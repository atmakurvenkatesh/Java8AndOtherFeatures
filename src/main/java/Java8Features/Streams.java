package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
	public static void main(String[] args) {

//		String s = "HACKERRANK!";
//		System.out.println(s.substring(5, 9));
//		System.out.println(s.substring(5, 1));

		List<Integer> a = new ArrayList<>() {
			{
				add(1);
				add(5);
			}

		};
		List<Integer> l = Arrays.asList(5, 6, 8, 3, 8, 3, 6, 4);

		// LIST CONVERTION TO MAP - count of items
		Map<Integer, Long> m = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		m.keySet().forEach(i -> System.out.println(i + "->" + m.get(i)));

		// MAP AND REDUCE - square and add
		System.out.println("square and sum:" + l.stream().map(i -> i * i).reduce(0, (i, j) -> i + j));

		// REDUCE AND OPTIONAL CLASS - max element
		System.out.println("max element: " + l.stream().reduce((i, j) -> i > j ? i : j).get());

		// FILTER - print event numbers sorted
		l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).stream().sorted().forEach(System.out::print);

		System.out.println("==================");

		// maximum repeated character of a string
		String s = "hi hello this is Oracle India, good afternoon";
		System.out.println(s.chars().map(c -> Character.toUpperCase(c)).mapToObj(c -> (char) c).filter(i -> i != ' ')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get().getKey());

		char ch = (char) s.chars().map(c -> (char) c).boxed().filter(i -> i != ' ')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey().intValue();
		System.out.println(ch);

		// get first non-repeated character of a String
		ch = "aabciosnbs".chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get().getKey();
		System.out.println(ch);

		// list of prime numbers generated from IntStream
		List<Integer> l1 = IntStream.rangeClosed(2, 20).filter(p -> {
			for (int itr = 2; itr <= p / 2; itr++) {
				if (p % itr == 0) {
					return false;
				}
			}
			return true;
		}).boxed().collect(Collectors.toList());
		System.out.println(l1);

		// check single number is prime or not
		int x = 17;
		System.out.println(x + " is prime? " + !IntStream.rangeClosed(2, x / 2).anyMatch(i -> x % i == 0));
		System.out.println(x + " is prime? " + IntStream.rangeClosed(2, x / 2).noneMatch(i -> x % i == 0));

		// Combining both above conditions, below logic
		// for generating prime number in a range of integers
		List<Integer> l2 = IntStream.rangeClosed(2, 20)
				.filter(p -> IntStream.rangeClosed(2, p / 2).noneMatch(i -> p % i == 0)).boxed()
				.collect(Collectors.toList());
		System.out.println(l2);

		// =========================================
		// ==============partitioningBy=============
		// =========================================

		IntStream.rangeClosed(2, 20).boxed().collect(Collectors.partitioningBy(i -> i % 3 == 0)).entrySet().stream()
				.forEach(System.out::println);

		// The parallelSort() is functionally different. Unlike sort(), which sorts data
		// sequentially using a single thread, it uses a parallel sort-merge sorting
		// algorithm. It breaks the array into sub-arrays that are themselves sorted and
		// then merged.
		int arr[] = { 99, 55, 203, 99, 4, 91 };
		Arrays.parallelSort(arr);

		record Notes(int id, String tagName, int tagId) {
		}
		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note3", 55));
		noteLst.add(new Notes(6, "note4", 66));
		noteLst.add(new Notes(7, "note4", 77));

		// =========================================
		// ==========Collectors.mapping()===========
		// =========================================

		noteLst.stream()
				.collect(Collectors.groupingBy(Notes::tagName, Collectors.mapping(Notes::tagId, Collectors.toList())))
				.entrySet().stream().forEach(System.out::println);

		System.out.println();

		// =========================================
		// ===========Collectors.toMap()============
		// =========================================

		/*-
		 * 3 different methods for Collectors.toMap()
		 * Collectors.toMap(Notes::tagName, Notes::tagId)                                           --> (Function, Function)
		 * Collectors.toMap(Notes::tagName, Notes::tagId, (oldV, newV) -> oldV)						--> (Function, Function, BinaryOperator)
		 * Collectors.toMap(Notes::tagName, Notes::tagId, (oldV, newV) -> oldV, LinkedHashMap::new)	--> (Function, Function, BinaryOperator, Supplier)
		 */

		System.out.println("Collectors.toMap()");

		noteLst.stream().sorted(Comparator.comparing(Notes::tagId).reversed())
				.collect(Collectors.toMap(Notes::tagName, Notes::tagId, (oldV, newV) -> oldV, LinkedHashMap::new))
				.entrySet().stream().forEach(System.out::println);

		// =========================================
		// ==========Collectors.groupingBy()========
		// =========================================

		/*-
		 * METHOD1:Collectors.groupingBy(Function);
		 * METHOD2:Collectors.groupingBy(Function, Collector);
		 * METHOD3:Collectors.groupingBy(Function, Supplier, Collector);
		 */

		System.out.println("Collectors.groupingBy()");

		// Collectors.groupingBy different cases
		l = Arrays.asList(2, 6, 3, 2, 5, 4, 5, 6, 3, 2, 3, 3, 5);
		l.stream().collect(Collectors.groupingBy(i -> i)).entrySet().stream().forEach(System.out::print);
		System.out.println();
		l.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
				.forEach(System.out::println);
		System.out.println();
		l.stream().collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.forEach(System.out::println);

	}
}
