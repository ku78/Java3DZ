package lesson3;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadPageByPage {
    final static int PAGE_SIZE = 1800;

    public static void readPage(String name){
  while (true) {
      long t = System.currentTimeMillis(), ti;

      Scanner scanner = new Scanner(System.in);

      System.out.print("Введите номер страницы (или 0 для выходя):");
      int page = scanner.nextInt() - 1;
      if (page >0) {


      try (
              RandomAccessFile raf = new RandomAccessFile(name, "r")) {
          byte[] bytes = new byte[PAGE_SIZE];
          raf.seek(page * PAGE_SIZE);
          ti = System.currentTimeMillis();
          int rd = raf.read(bytes, 0, PAGE_SIZE);
          System.out.println("Время чтения: " + (System.currentTimeMillis() - ti) / 1000 + " сек.");
          if (rd > 0) {
              System.out.println(new String(bytes, 0, rd));
          }

      } catch (
              IOException e) {
          e.printStackTrace();
      }
      System.out.println("Время выполнения: " + (System.currentTimeMillis() - t) / 1000 + " сек.");
      } else{break;}
  }//end while
    }//end readPage

}
