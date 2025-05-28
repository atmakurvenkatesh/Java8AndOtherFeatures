package Java8Features;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ForEachAndStringJoiner {

	public static void main(String[] args) {

		StringJoiner joiner = new StringJoiner(",", "Characters:", ";");
		joiner.add("a");
		joiner.add("b");
		joiner.add("c");
		joiner.add("d");
		System.out.println(joiner.toString());

		String s = joiner.toString();
		List<String> alpha = Arrays.asList(s.split(","));
		alpha.forEach(System.out::println);

	}

}
