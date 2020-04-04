package lesson1.z2;
import java.util.ArrayList;
import java.util.Collections;
//2. Написать метод, который преобразует массив в ArrayList;
public class Arrays<T>{
    private T[] arr;
    ArrayList<T> arrChan = new ArrayList<T>();
    public Arrays(T...arr) {
        this.arr = arr;
    }
    public void changes(){
        Collections.addAll(arrChan,arr );
        System.out.println("\nArray в ArrayList с помощью метода Collections.addAll()");
        System.out.print(arrChan.getClass()+": ");
        for (Object arr : arrChan)
            System.out.print(" " + arr);

    }


}
