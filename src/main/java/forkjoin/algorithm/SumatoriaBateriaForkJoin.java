package forkjoin.algorithm;

import forkjoin.Dispositivo;

import java.util.concurrent.RecursiveAction;

public class SumatoriaBateriaForkJoin extends RecursiveAction {

    private final Dispositivo[] input;
    private final int startIndex, endIndex;
    private double value;

    public SumatoriaBateriaForkJoin(Dispositivo[] input, int startIndex, int endIndex) {
        this.input = input;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public double getValue() {
        return value;
    }

    @Override
    protected void compute() {
        System.out.println("Ejecutando en el hilo: " + Thread.currentThread().getName() +
                " | Rango: [" + startIndex + ", " + endIndex + "]");
        final int threshold = 5;
        if ((endIndex - startIndex) <= threshold){
            // Caso base: sumar los valores directamente
            for (int i = startIndex; i < endIndex; i++){
                value += input[i].getBateria();
            }
        } else {
            // Caso recursivo: dividir la tarea en dos
            int middleIndex = (endIndex + startIndex) / 2;
            SumatoriaBateriaForkJoin left = new SumatoriaBateriaForkJoin(input, startIndex, middleIndex);
            SumatoriaBateriaForkJoin right = new SumatoriaBateriaForkJoin(input, middleIndex, endIndex);

            left.fork();
            right.compute();
            left.join();
            value = left.value + right.value;
        }
    }
}
