package lesson4;

public class MyThread extends Thread {
    private int nomer;

    static final Object obj = new Object();
    static volatile int a = 1;
    static volatile int numberOfTimes = 0;
    public MyThread(String name,int nomer) {
        super(name);
        start();
        this.nomer = nomer;

    }

    @Override
    public void run() {
        synchronized (obj){
            while (numberOfTimes<5) {
                if (a == nomer) {
                    System.out.print(getName());
                    a++;
                    if (a>3) {
                        a = 1;
                        numberOfTimes++;
                    }//end if
                    obj.notifyAll();
                } else { //end if
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//end catch
                }//end else
            }//end while
        }//end synchronized (obj)
    }
}

