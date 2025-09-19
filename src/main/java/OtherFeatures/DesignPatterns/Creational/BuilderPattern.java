package OtherFeatures.DesignPatterns.Creational;

public class BuilderPattern {

	public static void main(String[] args) {
		// Example usage of the Builder pattern
		Person person = new Person.Builder("John", "Doe").age(30).address("123 Main St").phoneNumber("123-456-7890")
				.build();

		System.out.println(person);
	}

	static class Person {
		private final String firstName;
		private final String lastName;
		private final int age;
		private final String address;
		private final String phoneNumber;

		public static class Builder {
			private final String firstName;
			private final String lastName;
			private int age;
			private String address;
			private String phoneNumber;

			public Builder(String firstName, String lastName) {
				this.firstName = firstName;
				this.lastName = lastName;
			}

			public Builder age(int age) {
				this.age = age;
				return this;
			}

			public Builder address(String address) {
				this.address = address;
				return this;
			}

			public Builder phoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
				return this;
			}

			public Person build() {
				return new Person(this);
			}
		}

		private Person(Builder builder) {
			this.firstName = builder.firstName;
			this.lastName = builder.lastName;
			this.age = builder.age;
			this.address = builder.address;
			this.phoneNumber = builder.phoneNumber;
		}

		@Override
		public String toString() {
			return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age
					+ ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
		}
	}

}
