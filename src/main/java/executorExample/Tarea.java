package executorExample;

public class Tarea implements Runnable{

    private String nombre;

    public Tarea(String nombre){
        super();
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(nombre);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }
}
