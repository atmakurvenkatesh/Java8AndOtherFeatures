package OtherFeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Temp2 {
	public static void main(String[] args) {
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

		noteLst.stream().collect(Collectors.toMap(Notes::tagName, Notes::tagId, (o, n) -> o)).entrySet().stream()
				.forEach(System.out::println);

		noteLst.stream().collect(Collectors.groupingBy(Notes::tagName)).entrySet().stream()
				.forEach(System.out::println);

		noteLst.stream()
				.collect(Collectors.groupingBy(Notes::tagName, Collectors.mapping(Notes::tagId, Collectors.toList())))
				.entrySet().stream().forEach(System.out::println);

//		Map<String, Integer> m = new HashMap<>();
//		noteLst.stream()
//				.collect(Collectors.groupingBy(Notes::tagName, Collectors.mapping(Notes::tagId, Collectors.toList())))
//				.entrySet().stream()
//				.forEach(e -> m.put(e.getKey(), e.getValue().stream().mapToInt(i -> i.intValue()).sum()));
//		m.entrySet().stream().forEach(System.out::println);

		/*
		 * Map<String, Set<LineItem>> itemsByCustomerName = orders.stream().collect(
		 * groupingBy(Order::getCustomerName, flatMapping(order ->
		 * order.getLineItems().stream(), toSet())));
		 */
	}

}