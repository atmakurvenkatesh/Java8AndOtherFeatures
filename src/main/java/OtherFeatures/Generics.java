package OtherFeatures;

public class Generics {
	public static void main(String[] args) {
		Pair<Character, Integer> pair = new Pair<>('A', 1);
		pair.display();
		pair.setValue(2);
		pair.display();
	}
}

class Pair<K, V> {

	private K key;
	private V value;

	Pair(K k, V v) {
		this.key = k;
		this.value = v;
	}

	public void setValue(V v) {
		this.value = v;
	}

	public void display() {
		System.out.println("key:" + key + ", value:" + value);
	}

}
