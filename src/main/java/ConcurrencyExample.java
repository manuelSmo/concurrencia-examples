public class ConcurrencyExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("thread 1 ejecutandose"));

        Thread thread2 = new Thread(() -> System.out.println("thread 2 ejecutandose"));

        thread1.start();
        thread2.start();
    }
}
