package StudentManagementSystem;

import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn(){
        String url = "jdbc:mysql://localhost:3306/studmonsys";
        String username = "root";
        String password = "rahul";
        try{
            c = DriverManager.getConnection(url, username,password);
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new conn();
    }

}