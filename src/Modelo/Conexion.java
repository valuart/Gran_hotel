package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Vanesa
 */
/*public class Conexion {
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
      
    
}*/

public class Conexion {
    private String url="jdbc:mysql://localhost/gran_hotel";
    private String usuario="root";
    private String password="";

    private Connection conexion;
    
    public Conexion() throws ClassNotFoundException{
            Class.forName("org.mariadb.jdbc.Driver");
        
    }
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        //Cargamos las clases de mariadb que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");

    }
    
    public Connection getConexion() throws SQLException{
        if(conexion == null){
                    // Setup the connection with the DB
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }
}


