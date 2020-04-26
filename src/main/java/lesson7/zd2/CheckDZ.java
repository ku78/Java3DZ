package lesson7.zd2;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class CheckDZ {
    private void check() throws Exception {

        File file = new File("/home/snip/111/");
        String[] fileList = file.list();

        ArrayList<String> fileName = new ArrayList<String>();

        for (String o : fileList) {
            String[] mass = o.split("\\.");
            if (mass[1].equalsIgnoreCase("class")) {
                fileName.add(mass[0]);
            }
        }

        for (String s : fileName) {
            String name = String.valueOf(s);
            Class ch = URLClassLoader.newInstance(new URL[]{new File("/home/snip/111/").toURL()}).loadClass("Main");
            Constructor constructor = ch.getConstructor();
            Object main = constructor.newInstance();

            Method calculate = ch.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
            calculate.setAccessible(true);
            int resultC = (Integer) calculate.invoke(main, 1, 1, 1, 1);
            System.out.println(resultC);

            Method checkTwoNumbers = ch.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
            checkTwoNumbers.setAccessible(true);
            boolean resultCTN = (Boolean) checkTwoNumbers.invoke(main, 10, 5);
            System.out.println(resultCTN);

            Method isNegative = ch.getDeclaredMethod("isNegative", int.class);
            isNegative.setAccessible(true);
            boolean resultIN = (Boolean) isNegative.invoke(main, -10);
            System.out.println(resultIN);

            Method isLeapYear = ch.getDeclaredMethod("isLeapYear", int.class);
            isLeapYear.setAccessible(true);
            boolean resultILY = (Boolean) isLeapYear.invoke(main, 2020);
            System.out.println(resultILY);

            if (resultC == 2 && resultCTN && resultIN && resultILY) {
                System.out.println(name + " Passed");
            } else {
                System.out.println(name + " Failed");
            }

        }
    }

    public static void main(String[] args){
        CheckDZ  checkHW = new CheckDZ();
        try {
            checkHW.check();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
