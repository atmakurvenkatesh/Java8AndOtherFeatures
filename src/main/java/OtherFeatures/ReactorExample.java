package OtherFeatures;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorExample {
	public static void main(String[] args) throws InterruptedException {
		Mono<User> userMono = findUserById("123");
		Flux<Order> ordersFlux = findOrdersForUser("123");

		Mono<UserWithOrders> result = userMono.zipWith(ordersFlux.collectList(),
				(user, orders) -> new UserWithOrders(user, orders));
		System.out.println("before sleep");
		Thread.sleep(5000);
		System.out.println("after sleep");

		result.subscribe(System.out::println); // Non-blocking

		System.out.println("after subscribe");
	}

	static Mono<User> findUserById(String id) {
		return Mono.just(new User(id, "Alice"));
	}

	static Flux<Order> findOrdersForUser(String id) {
		return Flux.just(new Order("Book"), new Order("Laptop"), new Order("Phone"));
	}
}
