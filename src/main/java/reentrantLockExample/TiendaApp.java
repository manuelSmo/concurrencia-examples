package reentrantLockExample;

public class TiendaApp {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        Runnable tarea = () -> {
            String nombre = Thread.currentThread().getName();
            service.procesarPedido(nombre);
        };

        for (int i = 1; i <= 10; i++){
            new Thread(tarea, "Cliente-" + i).start();
        }
    }
}
