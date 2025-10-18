import java.util.*;

import java.util.concurrent.*;

import java.util.stream.*;

public class CompletableFutureExample2 {

    record User(int id, String name, int age) {}

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<List<User>> usersFuture = CompletableFuture.supplyAsync(() -> getUsers(), executor);

        CompletableFuture<List<String>> namesFuture = usersFuture

                .thenApplyAsync(users -> users.stream()

                        .filter(u -> u.age() > 20)

                        .map(User::name)

                        .sorted()

                        .collect(Collectors.toList()), executor);

        namesFuture.thenAcceptAsync(names -> 

            System.out.println("Eligible user names: " + names)

        ).join();

        executor.shutdown();

    }

    private static List<User> getUsers() {

        return List.of(

            new User(1, "Alice", 22),

            new User(2, "Bob", 19),

            new User(3, "Charlie", 25)

        );

    }

}


 
