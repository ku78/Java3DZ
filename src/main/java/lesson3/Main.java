package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


/**1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;

 Последовательно сшить 5 файлов в один (файлы примерно 100 байт).

 Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ...
 Enumeration<InputStream> e = Collections.enumeration(al);

 Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
 Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
 Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение –
 занимать свыше 5 секунд.

 Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.*/
public class Main {

    public static void main(String[] args) throws IOException {
        listFileContent("fils/1.txt");
        ArrayList<InputStream> ali = new ArrayList<>();
        for (int i = 2; i <= 6; i++) {
            ali.add(new FileInputStream("fils/"+i + ".txt"));
        }
        fileJoin(ali);
        listFileContent("fils/7.txt");

          ReadPageByPage.readPage("fils/8.txt");
    }//end main

    public static void listFileContent(String name){
        try (FileInputStream in = new FileInputStream(name)){
            byte[] arr = new byte[512];
            int x;
            System.out.println("Имя файла: "+name);
            System.out.println("Размер файла: "+in.getChannel().size()+" байт");
            System.out.println("Тект файла: ");
            while ((x = in.read(arr)) > 0) {//read() считывает один байт из потока и возрощает int в диапазоне от 0 до 255
                System.out.print(new String(arr, 0, x));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }//end listFileContent
    public static void fileJoin(ArrayList<InputStream> ali) throws IOException {

        Enumeration<InputStream> in = Collections.enumeration(ali);
        SequenceInputStream sis = new SequenceInputStream(in);
        FileOutputStream fos = new FileOutputStream("fils/7.txt");

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);

            fos.flush();
        }
        fos.close();
        sis.close();

    } //end fileJoin

}//end Main
