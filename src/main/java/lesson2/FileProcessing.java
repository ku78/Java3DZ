package lesson2;
import java.io.FileNotFoundException;
import java.sql.*;
import java.io.FileReader;
import java.io.IOException;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.Scanner;

public class FileProcessing {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    public static void main(String[] args) throws SQLException {
        String tabl="students";
        ArrayList<String> arrChan = new ArrayList<String>();
        try(FileReader reader = new FileReader("DZ_update.txt"))
        {
            fileProce(arrChan,reader);

            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        select(tabl);
        for (String str  :arrChan){
            update(str);

        }//end for
        select(tabl);
        disconnect();
    }
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void fileProce (ArrayList arrChan, FileReader reader )  {//обработка файла
        Scanner scan = new Scanner(reader);

        int i = 0;

        while (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            if (!str2.equals("\uFEFF"+ "Обновить данные по студентам в базе")&&!str2.equals("Исходные данные")&&!str2.equals("id name score") ){

                arrChan.add(i,str2);
                i++;}
        }
    }
    public static void select(String nameTab) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM "+nameTab);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
        System.out.println("\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+
                "\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e "+"\ud83d\ude3e ");

    }

    public static void update(String str) throws SQLException {
            String[] arr = str.split(" ");
            ResultSet rs = stmt.executeQuery("SELECT id,name, score FROM students where id=" + arr[0]);
            if (rs.next()){
                if(rs.getInt("id") == Integer.parseInt( arr[0]) && !rs.getString("score").equals(arr[4])) {
                    connection.setAutoCommit(false);
                    stmt.executeUpdate("UPDATE students SET score =" +arr[4]  + " where id =" + arr[0]);
                    connection.setAutoCommit(true);}//end if id
            }//end if rs
            else if(!rs.next()){
                connection.setAutoCommit(false);
                stmt.executeUpdate("INSERT INTO students (id, name, score) VALUES ("+arr[0]+",'"+arr[2]+"',"+arr[4]+")") ;
                connection.setAutoCommit(true);
            }



    }//end update


}
