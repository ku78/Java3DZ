package lesson2;
import java.sql.*;
//1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)
public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {
        String tabl="dikanat";
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        create(tabl,"name","score");
        insert(tabl,"Chip", "20");
        insert(tabl,"Gaichka", "30");
        insert(tabl,"Deil", "30");
        select(tabl);
        update(tabl,"name","Roki","1");
        update(tabl,"name","Donald","2");
        update(tabl,"name","Vqik","3");
        select(tabl);
        delete(tabl,"1");
        select(tabl);
        drop(tabl);
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
    public static void create(String nameTab, String name,String score) throws SQLException {
        int create = stmt.executeUpdate("CREATE TABLE "+nameTab+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                name +" TEXT," +
                score+" TEXT)");
        System.out.println("Create "+create);//
    }

    public static void insert(String nameTab, String name,String score) throws SQLException {
        connection.setAutoCommit(false);
        String str = "INSERT INTO "+nameTab+" (name,score) VALUES ('"+ name +"'" +"," +score+")";
        stmt.executeUpdate(str);
        connection.setAutoCommit(true);
        System.out.println("Insert");
    }

    public static void select(String nameTab) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM "+nameTab);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
        System.out.println("Select");

    }
    public static void  update(String nameTab,String pName, String name,String id) throws SQLException {
        connection.setAutoCommit(false);
        stmt.executeUpdate("UPDATE "+nameTab+" SET "+pName+" ="+"'"+name+"' where id = "+id);//
           connection.setAutoCommit(true);
        System.out.println("Update");
    }
    public static void delete(String nameTab, String id) throws SQLException {
        stmt.executeUpdate("DELETE FROM "+nameTab+"  WHERE id ="+id);
        System.out.println("Delete");
    }
    public static void drop (String nameTab) throws SQLException {
        int del = stmt.executeUpdate("DROP TABLE "+nameTab);

        System.out.println("Drop "+del);
    }
    }

