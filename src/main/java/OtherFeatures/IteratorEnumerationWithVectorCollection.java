package OtherFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class IteratorEnumerationWithVectorCollection {
	public static void main(String[] args) {

		// FAIL-SAFE
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(2);
		v.add(3);

		System.out.println("using Enumeration");
		Enumeration<Integer> e = v.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

		System.out.println("using Iterator");
		Iterator<Integer> i = v.iterator();
		while (i.hasNext()) {
			Integer x = i.next();
			System.out.println(x);
			if (x == 2) {
				i.remove();
			}
		}
		System.out.println("modified Vector" + v);

		// FAIL-FAST

		/*
		 * To know whether the collection is structurally modified or not, fail-fast
		 * iterators use an internal flag called modCount which is updated each time a
		 * collection is modified.Fail-fast iterators checks the modCount flag whenever
		 * it gets the next value (i.e. using next() method), and if it finds that the
		 * modCount has been modified after this iterator has been created, it throws
		 * ConcurrentModificationException.
		 */
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println("Iterating arraylist- " + s);
			if (s.equals("one")) {
				list.remove(s); // Structural modification causes exception
			}
		}
		System.out.println("modified List" + list);
	}
}
