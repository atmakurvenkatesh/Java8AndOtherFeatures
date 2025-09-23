package OtherFeatures;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
	public static void main(String[] args) throws InterruptedException {
		CompletableFuture<User> userFuture = CompletableFuture.supplyAsync(() -> findUserById("123"));

		CompletableFuture<List<Order>> ordersFuture = CompletableFuture.supplyAsync(() -> findOrdersForUser("123"));

		// Combine results
		CompletableFuture<UserWithOrders> result = userFuture.thenCombine(ordersFuture,
				(user, orders) -> new UserWithOrders(user, orders));
		System.out.println("before accept");
		result.thenAccept(System.out::println);
		Thread.sleep(5000);
		System.out.println("after accept");

		// Block main thread to see result (not ideal in real apps)
		result.join();
		System.out.println("after join");
	}

	static User findUserById(String id) {
		return new User(id, "Alice");
	}

	static List<Order> findOrdersForUser(String id) {
		return List.of(new Order("Book"));
	}
}

record User(String id, String name) {
}

record Order(String id) {
}

record UserWithOrders(User user, List<Order> order) {
}
