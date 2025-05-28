package OtherFeatures;

public class NewInstanceMethod {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("NewInstanceMethod");
		NewInstanceMethod obj = (NewInstanceMethod) cls.newInstance();
		System.out.println(obj);
	}
}

