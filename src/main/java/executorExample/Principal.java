package executorExample;

public class Principal {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea("tarea1"));
        t1.start();

        Thread t2 = new Thread(new Tarea("tarea2"));
        t2.start();

        Thread t3 = new Thread(new Tarea("tarea3"));
        t3.start();
    }
}
