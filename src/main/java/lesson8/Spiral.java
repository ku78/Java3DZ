package lesson8;
public class Spiral {
    public static void main(String[] args) {

        int lines = 5;  //количество строк
        int columns = 7; //количество столбцов
        int[][] arr = new int[lines][columns];
        arr = spiral(arr);
        printM(arr);

    }

    private static int [][] spiral(int [][] arr){
        int k = 1;       // значение первого элемента
        int y = arr.length;   //количество строк
        int x = 0;          //количество столбцов
        if (y > 0){
            x = arr[0].length;
            if (x < 1){
                sMessage();
                return arr;
            }
        }else {
            sMessage();
            return arr;
        }
        int[][] array = new int [x][y]; //матрица с размерами для обработки поворота
        int min = y <= x ? y : x;  // определение меньшего размера матрицы
        if (min == 2){
            min = min-1;
        }else if (min > 2){
            min = min-2;
        }

        //вычисления
        int b = 0;
        while (b < min){
            for (int i = 0; i < 4; i++){
                if (i%2 == 0){                  //еcли 0 или 2,
                    k = fill(k, arr[b]);         // то заполняем строку массива a
                    array = turnToLeft(arr);         //поворот на 90 градусов
                }else {                         //еcли 1 или 3,
                    k = fill(k, array[b]);        //то заполняем строку массива aa
                    arr = turnToLeft(array);         //поворот на 90 градусов
                }
            }
            b++;
        }
        return arr;
    }

    //заполнение строки матрицы
    private static int fill(int k, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = k;
                k++;
            }
        }
        return k;
    }

    //поворот влево
    private static int[][] turnToLeft(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr[i].length - 1 - j][i] = arr[i][j];
            }
        }
        return result;
    }

    //показать матрицу
    private static void printM(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%4d", ints[j]);
            }
            System.out.println();
        }
    }

    private static void sMessage() {
        System.out.println("Мин матрица 1х1");
    }
}
