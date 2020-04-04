package lesson1.z1;
import java.util.Scanner;
//Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

public class Arrays<T> {
    private T[] arr;


    public Arrays(T...arr) {
        this.arr = arr;
    }

    public void edit() {
        Object arrN[] = new Object[arr.length];
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);


        System.out.println("Введите индекс от 0 до "+(arr.length-1));
        int index1 = scan1.nextInt();
        int index2 = scan2.nextInt();
        for (int i = 0; i <arr.length ; i++) {
            if(i==index1){
                arrN[i]=arr[index2];
            }else if(i==index2){
                arrN[i]=arr[index1];
            }else{arrN[i]=arr[i];}
            System.out.println("Блыло: "+arr[i]+" Стало: "+arrN[i]);
        }

        System.out.println("\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+
                "\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e ");
    }
}
