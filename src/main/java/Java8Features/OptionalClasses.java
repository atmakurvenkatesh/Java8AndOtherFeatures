package Java8Features;
import java.util.Optional;

public class OptionalClasses {
	// Optional is public final class and used to deal with NullPointerException in Java application
	public static void main(String[] args) {
		String[] str = new String[10];

		// without Optional
		String lowercaseString = str[5].toLowerCase();
		System.out.print(lowercaseString);

		// with Optional classes
		Optional<String> checkNull = Optional.ofNullable(str[5]);
		if (checkNull.isPresent()) { // check for value is present or not
			String lowercaseString2 = str[5].toLowerCase();
			System.out.print(lowercaseString2);
		} else
			System.out.println("string value is not present");
	}
}