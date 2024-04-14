package database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try{
            DriverManager.registerDriver(new Driver());

            String jdbcUrl = "jdbc:mySQL://localhost:3306/botstories";
            String username = "root";
            String password = "123456";

            //tạo kết nối
            c = DriverManager.getConnection(jdbcUrl,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c){
        try{
            if(c != null){
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c){
        try{
            if(c!=null){
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
