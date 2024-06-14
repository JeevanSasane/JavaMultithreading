
class A {
    public void show(){
        System.out.println("In show");
    }
}

class Hi extends A implements Runnable {

    public void run(){
        for (int i=1;i<=5;i++){
            show();
            System.out.println("Hiii");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Hello extends Thread {
    public void run(){
        for (int i=1;i<=5;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Hi hi=new Hi();
        Hello hello=new Hello();

        Thread t1=new Thread(hi);
//        Thread t2=new Thread();
        t1.start();
//        hi.run();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hello.start();

//        hi.show();
//        hello.show();
    }
}



