import java.util.concurrent.CompletableFuture;

public class Solve {
    private String connectionString = "fa[weouif;aokjsgvoilasdfl;j]";

    public void Start() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Connecting to database ... " + connectionString);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new ItemDB(12, "Name", 18);
        }).thenAccept(result -> 
            System.out.println("Id: " + result.id + " Name: " + result.Name + " Age: " + result.age)
        );

        future.join();
    }
}