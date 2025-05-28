package OtherFeatures;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IteratorEnumerationWithVectorCollection {
	public static void main(String[] args) {
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
	}
}
