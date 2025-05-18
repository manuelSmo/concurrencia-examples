package synchronizedExample;

public class SynchronizedExample {

    public static void main(String[] args) {
        final Cart cart = new Cart();

        //Se crean dos hilos que intentaran agregar elementos a la lista simulataneamente
        Thread thread1 = new Thread(() -> {
            cart.add("Producto 1");
        });

        Thread thread2 = new Thread(() -> {
            cart.add("Producto 2");
        });

        thread1.start();
        thread2.start();

        //se espera a que ambos hilos terminen
        try {
            thread1.join();
            thread2.join();
            System.out.println("Lista final: " + cart.getProducts());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
