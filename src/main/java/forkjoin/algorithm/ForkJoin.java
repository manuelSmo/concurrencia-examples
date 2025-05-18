package forkjoin.algorithm;

import forkjoin.Dispositivo;


import java.util.concurrent.ForkJoinPool;

public class ForkJoin {
    public static void main(String[] args) {

        //crea ela rreglo de dispositivos
        Dispositivo[] dispositivos = new Dispositivo[20];
        for (int i = 0; i < dispositivos.length; i++) {
            dispositivos[i] = new Dispositivo("prueba", (int) (Math.random() * 100), "prueba"); // Nivel de batería aleatorio entre 0 y 100
        }

        System.out.println("Dispositivos:");
        for (Dispositivo dispositivo : dispositivos) {
            System.out.println(dispositivo);
        }

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SumatoriaBateriaForkJoin testParallel = new SumatoriaBateriaForkJoin(dispositivos, 0, dispositivos.length);
        pool.invoke(testParallel);
        double promedioBateria = testParallel.getValue() / dispositivos.length;

        System.out.println("\nSuma total de las baterías: " + testParallel.getValue());
    }
}
