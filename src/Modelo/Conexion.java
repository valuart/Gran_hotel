package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Vanesa
 */
public class Conexion {
    private  String url="jdbc:mysql://localhost:3306/gran_hotel";
    private  String user="root";
    private  String pass="";
    private Connection con;
    
    public Connection  getConexion()  {
      try{
          Class.forName("com.mysql.jdbc.Driver");   //carga el driver maria db o en este caso el driver mysql
          con = DriverManager.getConnection(url,user,pass);
          System.out.println("Conexion exitosa!");
      }
      
      catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
      return con;
      
    
}

}
