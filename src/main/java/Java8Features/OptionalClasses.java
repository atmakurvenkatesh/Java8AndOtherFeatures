package Java8Features;

import java.util.Optional;

//Optional is public final class and used to deal with NullPointerException in
// Java application
public class OptionalClasses {

	public static void main(String[] args) {
		String[] str = new String[10];

		/*-
		 * ==== without Optional ====
		 * String lowercaseString = str[5].toLowerCase();
		 * System.out.print(lowercaseString);
		 */

		// ==== with Optional Class ====

		/*-
		 * ofNullable() - Returns an Optional describing the given value, if non-null, otherwise returns an empty Optional.
		 * of() - Returns an Optional describing the given non-null value.NullPointerException - if value is null
		 */
		Optional<String> checkNull = Optional.ofNullable(str[5]);
//		Optional<String> checkNull = Optional.of(str[5]); 

		if (checkNull.isPresent()) { // check for value is present or not
			String lowercaseString2 = str[5].toLowerCase();
			String lowercaseString3 = checkNull.get().toLowerCase();
			System.out.print(lowercaseString2);
			System.out.print(lowercaseString3);
		} else {
			System.out.println("string value is not present");
		}
		System.out.println(checkNull.orElse("No Value is Present"));
		System.out.println(checkNull.orElseThrow());

	}
}