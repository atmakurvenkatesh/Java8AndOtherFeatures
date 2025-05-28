package OtherFeatures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

class Dummy implements Comparable<Dummy> {
	int key;
	int value;

	Dummy() {
	}

	Dummy(int key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(Dummy o) {
		return this.value - o.value;
	}

	@Override
	public String toString() {
		return "Dummy [key=" + key + ", value=" + value + "]";
	}

}

public class PriorityQueueExample {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(2, 6, 3, 2, 5, 4, 5, 6, 3, 2, 3, 3, 5, 6, 6, 6, 2, 2, 2, 2);
		int k = 3;
		Map<Integer, Integer> m = l.stream().collect(Collectors.groupingBy(Function.identity(),
				Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
		System.out.println(m);
//		m = m.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder())).limit(k).collect(
//				Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (o, n) -> n, LinkedHashMap::new));
//		System.out.println(m);
		System.out.println("===========");
		PriorityQueue<Dummy> q = new PriorityQueue<Dummy>(k);
		for (Entry<Integer, Integer> e : m.entrySet()) {
			if (q.size() < k) {
				q.add(new Dummy(e.getKey(), e.getValue()));
			} else {
				if (e.getValue() > q.peek().value) {
					q.poll();
					q.add(new Dummy(e.getKey(), e.getValue()));
				}
			}
			System.out.println(q);
		}
		q.forEach(d -> System.out.println(d.key + " " + d.value));
		System.out.println(q.size());
	}
}
