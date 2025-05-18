package forkjoin;

import java.util.ArrayList;
import java.util.List;

public class StreamForkJoin {

    public static void main(String[] args) {
        List<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(new Dispositivo("prueba", 10, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 20, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 20, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 30, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 50, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 80, "prueba"));
        dispositivos.add(new Dispositivo("prueba", 90, "prueba"));

        double promedioBateria = dispositivos
                .parallelStream()
                .mapToDouble(Dispositivo::getBateria)
                .average()
                .orElse(0);

        System.out.println("Promedio de la bateria: " + promedioBateria);
    }
}
