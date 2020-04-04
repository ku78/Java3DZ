package lesson1.z1;

//Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

public class EditItems {
    public static void main(String[] args) {
        Arrays<String> arr = new Arrays<>("V","i","t","a","l","i","k");
        Arrays<Integer> arr2 = new Arrays<>(5,3,4,5,6,7,8,3);
        arr.edit();
        arr2.edit();

    }
}

