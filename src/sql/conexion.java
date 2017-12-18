package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    public static Connection getConexion() {
        Connection connection = null;
        try {
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost/usuario01";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "root","toor");
           //System.out.println("Conexion exitosa!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}