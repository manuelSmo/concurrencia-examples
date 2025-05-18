import java.util.stream.IntStream;

public class ParallelismExample {
    public static void main(String[] args) {
        IntStream.range(1, 10).parallel().forEach(i -> {
            System.out.println("Procesando " + i + " en " +  Thread.currentThread().getName());
        });

        IntStream.range(1, 5).forEach(i -> {
            System.out.println("Procesando " + i + " en " +  Thread.currentThread().getName());
        });
    }
}
