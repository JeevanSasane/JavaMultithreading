public class MyThread {

    int[] values = {6, 5, 1, 7, 8};

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }

    public void run() {

        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] * 2;
            System.out.println(values[i] * 2);
        }
    }
}

