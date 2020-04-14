package lesson4;
/**1. Создать три потока, каждый из которых выводит определенную букву (A, B и C)
 * 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.*/
public class Main {

    public static void main(String[] args)  {
        MyThread threadA = new MyThread("A", 1);
        MyThread threadB = new MyThread("B", 2);
        MyThread threadC = new MyThread("C", 3);

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
