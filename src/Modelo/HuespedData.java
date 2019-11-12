package Modelo;


import Modelo.Huesped;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class HuespedData {
    Connection con= null;       
    
    public HuespedData(Conexion conexion){
        
        con= conexion.getConexion();       //constructor que recive un tipo conexion de la clase Conexion
                                            //para conectarse a la BD y editarla
        
    }
    
    public void guardarHuesped(Huesped huesped){   //recive un huesped y lo edita para subirlo a la BD 
        String sql="INSERT INTO huesped(Nombre, Domicilio, Dni, Celular, Correo) VALUES (?,?,?,?,?)";//no se pone el id porque es autoincrementable, se pasa los valores de forma dinamica(VALUES)
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {//sql String que creamos arriba y una vez ingresamos este string le
                ps.setString(1,huesped.getNombre());
                ps.setString(2,huesped.getDomicilio());
                ps.setInt(3,huesped.getDni());                                                       // pido que devuelva la lista de clave de huesped(con Statement)
                ps.setInt(4,huesped.getCelular());
                ps.setString(5,huesped.getCorreo()); 
                
                                                         //se saca la informacion de huesped mediante los metodos get
                                                        //para subirlos a la BD
                ps.executeUpdate();     //a travez de la coneccion con hace un INSERT a la BD
                ResultSet rs= ps.getGeneratedKeys();    //resulset(matriz) le devuelve una tabla con la lista de claves
                                                        //1 columna con todas las claves y tantas filas como huesped tenga
                
                if(rs.next()){  //la primer fila corresponde al ultimo huesped que ingresamos
                    huesped.setId_huesped(rs.getInt(1)); //recupero ID es autoincrementable
                    
                }else{
                    System.out.println("No se pudo obtener el ID de huesped " );
                }
                
                ps.close();//cerrar el ps
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el huesped");
        }
        
    }
    
    public List<Huesped> obtenerHuesped(){
        List<Huesped> huespedes = new ArrayList<Huesped>();  //afuera del try catch para que se pueda retornar al final
        try {          
            String sql=("SELECT * FROM huesped") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         //devuelve lista (fila de huesped que pedi(nombre,dni,domicilio,correo,celular))
            //tantas filas como huesped tiene la BD
            
            Huesped huesped;  //para recorrer todo el huesped
            while(rs.next()){   //mientras ese rs tenga filas que reccorer
                huesped=new Huesped();        //uso constructor vacio de huesped
                huesped.setId_huesped(rs.getInt(1));
                huesped.setNombre(rs.getString(2));
                huesped.setDomicilio(rs.getString(3));
                huesped.setDni(rs.getInt(4));
                huesped.setCelular(rs.getInt(5));
                huesped.setCorreo(rs.getString(6));
                
                
                //va a ir leyendo todo el resultset(matriz) y se la da a la lista huesped
                huespedes.add(huesped);        //huesped es de tipo lista
            }
            ps.close();//cierro la conexion
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar huesped" );
        }
        return huespedes;
    }
    
    
    public Huesped buscarHuesped(int id_Huesped){   //devuelve un objeto de tipo (huesped)    
        Huesped huesped = null;                   //variable de tipo huesped
        try {
        String sql=("SELECT * FROM huesped WHERE id=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_Huesped);                //seteo el id de huesped con el parametro que pase (id_huesped)
        ResultSet rs= ps.executeQuery();        //el executeQuery devuelve un RESULTSET
                                                //deveria devolver una sola fila pero se recoore igual
        while(rs.next()){
            huesped= new Huesped();       //objeto de tipo huesped
            huesped.setId_huesped(rs.getInt(1));
            huesped.setNombre(rs.getString(2));
            huesped.setDomicilio(rs.getString(3));
            huesped.setDni(rs.getInt(4));
            huesped.setCelular(rs.getInt(5));
            huesped.setCorreo(rs.getString(6));
          
            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar huesped");
        }
        return huesped;      //este es el objeto que devuelve de tipo huesped
        
    }
    
  
    public void actualizarHuesped(Huesped huesped){
        try {
            
            String sql=("UPDATE huesped SET nombre=?, dni=?, domicilio=?, correo=? , celular=?, WHERE id=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getDomicilio());
            ps.setInt(3,huesped.getDni());
            ps.setInt(4, huesped.getCelular());
            ps.setString(5, huesped.getCorreo());
            ps.setInt(6, huesped.getId_huesped());
           
            
            ps.executeUpdate(); //siempre que haga un INSERT DELET O UPDATE
                                // si lo que ejecuto es una consulta SELECT es executeQuery()
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR huesped ");
        }
        
    }
    
    
    public void borrarHuesped(int id){
        try {
            String sql="DELETE FROM huesped WHERE id=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_huesped);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORAR un huesped");
        }
    }
}

