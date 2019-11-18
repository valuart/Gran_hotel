
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HabitacionData {                   
   
    Connection con= null;       
    
    public HabitacionData(Conexion conexion){
        
        try {                                                     
            con= conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarHabitacion(Habitacion habitacion){   
        String sql="INSERT INTO habitacion(Piso,Numero,Estado) VALUES (?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1,habitacion.getPiso());
                ps.setInt(2,habitacion.getNumero());
                ps.setBoolean(3,habitacion.getEstado());// pido que devuelva la lista de clave de huesped(con Statement)
                                                             
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                    habitacion.getId_habitacion(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID de habitacion " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar una habitacion");
        }
        
    }
    
    public List<Habitacion> obtenerHabitacion(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();  
        try {          
            String sql=("SELECT * FROM habitacion") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();        
            
            Habitacion habitacion;  
            while(rs.next()){   
                habitacion=new Habitacion();        
                habitacion.getId_habitacion();
                habitacion.setPiso(rs.getInt(2));
                habitacion.setNumero(rs.getInt(3));
                habitacion.setEstado(rs.getBoolean(4));
                        
                habitaciones.add(habitacion);       
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar una habitacion" );
        }
        return habitaciones;
    }
    
    
    public Habitacion buscarHabitacion(int id_Habitacion){   
        Habitacion habitacion = null;                  
        try {
        String sql=("SELECT * FROM habitacion WHERE id_habitacion=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_Habitacion);                
        ResultSet rs= ps.executeQuery();        
        
        while(rs.next()){
            habitacion= new Habitacion();       
            habitacion.getId_habitacion();
            habitacion.setPiso(rs.getInt(2));
            habitacion.setNumero(rs.getInt(3));
            habitacion.setEstado(rs.getBoolean(4));
            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar habitacion");
        }
        return habitacion;      
        
    }
    
  
    public void actualizarHabitacion(Habitacion habitacion){
        try {
            
            String sql=("UPDATE habitacion SET Piso=?, Numero=?, Estado=?, WHERE id_habitacion=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, habitacion.getPiso());
            ps.setInt(2, habitacion.getNumero());
            ps.setBoolean(3,habitacion.getEstado());
            ps.setInt(6, habitacion.getId_habitacion());
            
            ps.executeUpdate(); 
            
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR habitacion ");
        }
        
    }
    
    
    public void borrarHabitacion(int id_habitacion){
        try {
            String sql="DELETE FROM habitacion WHERE id_habitacion=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_habitacion);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR una habitacion");
        }
    }
}


