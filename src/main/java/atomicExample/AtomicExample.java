package atomicExample;

public class AtomicExample {

    public static void main(String[] args) {

        final Item item = new Item("Producto 1");

        // Creamos dos hilos que intentarán agregar elementos a la lista simultáneamente
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                item.add();
                item.addNoAtomic();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                item.add();
                item.addNoAtomic();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(item);
    }
}
