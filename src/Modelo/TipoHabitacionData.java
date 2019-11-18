/*  private int id_TipoHab;
    private TipoCama tipoCama;
    private Habitacion habitacion;
    private String descripcion;
    private double precio;
 */
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


public class TipoHabitacionData {
    Connection con= null;       
    Conexion conexion;
    
    public TipoHabitacionData(Conexion conexion){
        try {
            con= conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            Logger.getLogger(TipoHabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion){   
        String sql="INSERT INTO tipo_habitacion(Tipo_Cama, Habitacion, Descripcion, Precio) VALUES (?,?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, tipoHabitacion.getTipoCama().getId_TipoCama());
                ps.setInt(2, tipoHabitacion.getHabitacion().getId_habitacion());
                ps.setString(3, tipoHabitacion.getDescripcion());
                ps.setDouble(4, tipoHabitacion.getPrecio());
                                                        
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                     tipoHabitacion.getId_TipoHab(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID del tipo de habitacion " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el tipo de habitacion");
        }
        
    }
    public List<TipoHabitacion> obtenerTipoHabitacion(){
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();  
        try {          
            String sql=("SELECT * FROM tipo_habitacion") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            TipoHabitacion tipoHabitacion;  
            while(rs.next()){   
              tipoHabitacion= new TipoHabitacion();
              tipoHabitacion.setId_TipoHab(rs.getInt(1));
              
              TipoCama tipoCama=buscarTipoCama(rs.getInt(2));   
              tipoHabitacion.setTipoCama(tipoCama);
              
              Habitacion habitacion = buscarHabitacion(rs.getInt(3));
              tipoHabitacion.setHabitacion(habitacion);
               
              tipoHabitacion.setDescripcion(rs.getString(4));
              tipoHabitacion.setPrecio(rs.getDouble(5));
                     
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar tipo de habitacion" );
        }
        return tipoHabitaciones;
    }
    
    
    public TipoHabitacion buscarTipoHabitacion(int id_TipoHab){     
        TipoHabitacion tipoHabitacion = null;                   
        try {
        String sql=("SELECT * FROM tipo_habitacion WHERE id_TipoHab=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_TipoHab);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            tipoHabitacion= new TipoHabitacion();       
            tipoHabitacion.setId_TipoHab(rs.getInt(1));
            
            TipoCama tc=buscarTipoCama(rs.getInt(2));
            tipoHabitacion.setTipoCama(tc);
            
            Habitacion h = buscarHabitacion(rs.getInt(3));
            tipoHabitacion.setHabitacion(h);
       
            tipoHabitacion.setDescripcion(rs.getString(4));  
            tipoHabitacion.setPrecio(rs.getDouble(5));
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar el tipo de habitacion");
        }
        return tipoHabitacion;      
        
    }
    
    public TipoCama buscarTipoCama(int id_TipoCama){
        
        TipoCamaData tcd = new TipoCamaData(conexion);
        return tcd.buscarTipoCama(id_TipoCama);
        
    
    }
    
    public Habitacion buscarHabitacion(int id_Hab){     
       
        HabitacionData hd= new HabitacionData(conexion);    
        return hd.buscarHabitacion(id_Hab);
    }
    
    
    public void borrarTipoHabitacion(int id_TipoHab){
        try {
            String sql="DELETE FROM tipo_habitacion WHERE id_TipoHab=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_TipoHab);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR un tipo de habitacion");
        }
    }
}
