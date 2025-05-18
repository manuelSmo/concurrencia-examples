package synchronizedExample;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<String> products = new ArrayList<>();

    public synchronized void add(String prod){
        System.out.println("Agregando: " + prod);
        this.products.add(prod);
    }

    public List<String> getProducts() {
        return products;
    }
}
