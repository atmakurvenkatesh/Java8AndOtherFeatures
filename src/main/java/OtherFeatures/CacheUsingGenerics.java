package OtherFeatures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CacheUsingGenerics {
	public static void main(String[] args) {
		Cacheble<Object> cache = new Cacheble<>();
		cache.add(1, "Sting 1");
		cache.add(2, 3);
		cache.add(3, new LinkedList<String>() {
			{
				add("frw");
			}
		});
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));

	}
}

class Cacheble<E> {
	private Map<Integer, E> map = new HashMap<>();

	void add(int i, E e) {
		map.put(i, e);
	}

	E get(int i) {
		return map.get(i);
	}
}
