import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Solve {
    Random r = new Random();
    public void Start(){
        CompletableFuture<Whether> future1 = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(r.nextInt(1000, 6000) * 1);
                return new Whether(40,12,39, "Dnipro");
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture<Whether> future2 = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(r.nextInt(1000, 6000) * 1);
                return new Whether(-5,12,12, "Kiev");
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture<Whether> future3 = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(r.nextInt(1000, 6000) * 1);
                return new Whether(15,90,8, "My vilage");
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
            
        });
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3)
        .thenRun(() -> {
            try {
                Whether result1 = future1.get();
                Whether result2 = future2.get();
                Whether result3 = future3.get();

                System.out.println(result1);
                System.out.println(result2);
                System.out.println(result3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        allFutures.join();

        
    }
}
