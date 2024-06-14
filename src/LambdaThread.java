class B {
    public void show() {
        System.out.println("In show");
    }
}

public class LambdaThread extends B {
    public static void main(String[] args) throws Exception {

        Runnable hi = (() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hiii "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Runnable hello = (() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t1 = new Thread(hi);
        Thread t2 = new Thread(hello);

        t1.setName("Thread One");
        t2.setName("Thread Two");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        System.out.println(t1.getPriority());
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();

//        LambdaThread thread=new LambdaThread();
//        thread.show();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        System.out.println(t1.isAlive());

        t1.join();
        t2.join();
        System.out.println(t1.isAlive());

        System.out.println("Bye");
//        hi.show();
//        hello.show();
    }
}



