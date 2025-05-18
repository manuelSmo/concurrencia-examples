package forkjoin;

public class Dispositivo {

    private int bateria;
    private String marca;
    private String modelo;

    public Dispositivo(String marca, int bateria, String modelo) {
        this.marca = marca;
        this.bateria = bateria;
        this.modelo = modelo;
    }

    public int getBateria() {
        return bateria;
    }

    @Override
    public String toString() {
        return "Dispositivo[bateria=" + bateria + "]";
    }
}
