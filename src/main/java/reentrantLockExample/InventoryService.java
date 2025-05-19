package reentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class InventoryService {

    private int stock = 5;
    private final ReentrantLock lock = new ReentrantLock();

    public boolean procesarPedido(String usuario){
        lock.lock();
        try {
            if (stock > 0){
                System.out.println(usuario + " compró 1 unidad. Stock restante: " + stock);
                stock--;
                return true;
            } else {
                System.out.println(usuario + " no pudo comprar. Sin stock");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}
