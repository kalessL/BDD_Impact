package manageOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    private static String url = "jdbc:mysql://localhost:3306/elevage";
    private static String user = "victor";
    private static String passwd = "qualvi";
    private static Connection connect;


    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}