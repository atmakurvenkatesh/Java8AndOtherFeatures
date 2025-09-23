package Java8Features;

import java.util.Arrays;

public class Streams2 {
	public static void main(String[] args) {

		// Dealing arrays with streams - START

		/*-  
			1D arrays → Arrays.stream(array)
			2D / Nested arrays → flatMap() or flatMapToInt()
			Object arrays → .toArray(String[]::new)
			Primitive arrays → .toArray()
			Ragged arrays handled the same way
			
			Array → List                : Arrays.stream(arr).toList()
			List → Array				: .stream().toArray(Type[]::new)
			List<String[]> → String[]   : .flatMap(Arrays::stream)
			Array<List<T>> → T[]		: .flatMap(List::stream).toArray(Type[]::new)
			Map → Array					: map.keySet().stream().toArray()
		*/

		// regular stream
		String[] fruits = { "apple", "banana", "mango" };
		String[] result = Arrays.stream(fruits).map(String::toUpperCase).toArray(String[]::new);

		// flatMap for Strings
		String[][] names = { { "Ram", "Shyam" }, { "Geeta", "Sita" }, { "Anil", "Ajay" } };
		result = Arrays.stream(names) // Stream<String[]>
				.flatMap(Arrays::stream) // flatten
				.filter(name -> name.startsWith("A")).map(String::toUpperCase).toArray(String[]::new);
		System.out.println(Arrays.toString(result)); // [ANIL, AJAY]

		// Flatten 2D → 1D and process
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] flatSquares = Arrays.stream(matrix) // Stream<int[]>
				.flatMapToInt(Arrays::stream) // flatten
				.map(n -> n * n).toArray();
		System.out.println(Arrays.toString(flatSquares));

		// Flatten 2D → 1D(boxed) and process
		Integer[] flatSquaresIntegers = Arrays.stream(matrix).flatMapToInt(Arrays::stream).map(n -> n * n).boxed()
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(flatSquaresIntegers));

		// Convert Integer[] → int[]
		Integer[] objectArray = { 1, 2, 3, 4, 5 };
		int[] primitiveArray = Arrays.stream(objectArray).mapToInt(Integer::intValue).toArray();

		// Convert int[] → Integer[]
		primitiveArray = new int[] { 1, 2, 3, 4, 5 };
		objectArray = Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);

		// Dealing arrays with streams - END

		// map vs mapToInt vs mapToObj - START
		/*-
			If starting with objects, use map().
			If you need primitives, use mapToInt(), mapToLong(), or mapToDouble().
			If you need to go back from primitive stream → objects, use mapToObj().
		 */
		int sum = Arrays.stream(fruits).mapToInt(String::length) // IntStream
				.sum();

		int[] ch = new int[] { 55, 56, 57, 58, 59 };
		Character[] cArray = Arrays.stream(ch).mapToObj(t -> (char) t).toArray(Character[]::new);

		// map vs mapToInt vs mapToObj - END
	}
}
