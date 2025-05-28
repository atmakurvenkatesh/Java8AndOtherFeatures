package OtherFeatures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] arr = new String[] { "eat", "ate", "deep", "eep", "sad", "das", "peed", "aet" };
		Arrays.stream(arr).collect(Collectors.groupingBy(str -> {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			return new String(charArr);
		})).entrySet().stream().forEach(System.out::println);
	}

}
