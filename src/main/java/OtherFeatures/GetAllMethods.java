package OtherFeatures;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GetAllMethods {

	// https://stackoverflow.com/questions/43585019/java-reflection-difference-between-getmethods-and-getdeclaredmethods
	public static void main(String[] args) {

		Class arrayListClass = ArrayList.class;

		/*
		 * getDeclaredMethods includes all methods declared by the class itself, whereas
		 * getMethods returns only public methods, but also those inherited from a base
		 * class (here from java.lang.Object).
		 */

//		Method					Public	Non-public	Inherited
//		getMethods()			✔️		❌			✔️
//		getDeclaredMethods()	✔️		✔️			❌
//		getPublicMethods()		✔️		❌			❌

		Method[] methods = arrayListClass.getMethods();

		Method[] declaredMethods = arrayListClass.getDeclaredMethods();

		for (Method method : declaredMethods) {
//			System.out.println(method);
			System.out.print(method.getName());
			Parameter[] parameters = method.getParameters();
			System.out.println(Arrays.stream(parameters).map(i -> i.getType().toString())
					.collect(Collectors.joining(",", "(", ")")));
		}

		// print annotations of a class
		Annotation[] annotations = Deprecated.class.getAnnotations();
		Arrays.stream(annotations).forEach(System.out::println);
	}
}
