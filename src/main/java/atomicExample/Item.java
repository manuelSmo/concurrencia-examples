package atomicExample;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {

    private final String name;
    private final AtomicInteger quantity;
    private int quantityNoAtomic = 0;

    public Item(String name) {
        this.name = name;
        quantity = new AtomicInteger();
    }

    public String getName(){
        return name;
    }

    public AtomicInteger getQuantity(){
        return quantity;
    }

    public void add(){
        this.quantity.incrementAndGet();
    }

    public void addNoAtomic(){
        quantityNoAtomic += 1;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", quantity=" + quantity
                + '\'' +
                ", quantityNoAtomic=" + quantityNoAtomic;
    }

}
