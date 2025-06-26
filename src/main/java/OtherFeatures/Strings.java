package OtherFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Strings {
	public static void main(String[] args) {

//		System.out.println(String.format("%d - > %s", 2, "sgedgnj"));

		List<String> l = Arrays.asList("fsdgre", "smytres", "tjjsw", "jtrers", "whfbx", "gerkuj");

		System.out.println(String.format("%5s -> %-7s : %s", "Index", "String", "Length"));
		IntStream.range(0, l.size())
				.mapToObj(index -> String.format("%5d -> %-7s : %d", index, l.get(index), l.get(index).length()))
				.forEach(System.out::println);

		System.out.println(String.join(",", l));

	}
}
