/*
 * private int id_TipoCama;
    private TipoHabitacion tipoHabitacion;
    private String tipo;
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


public class TipoCamaData {
    Connection con= null; 
    Conexion conexion;
    
    public TipoCamaData(Conexion conexion){
        try {
            con= conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            Logger.getLogger(TipoCamaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarTipoCama(TipoCama tipoCama){   
        String sql="INSERT INTO tipo_Cama(Tipo_habitacion, Tipo) VALUES (?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,tipoCama.getTipoHabitacion().getId_TipoHab());
                ps.setString(2,tipoCama.getTipo());
                                                        
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                    tipoCama.getId_TipoCama(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID del tipo cama " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el tipo cama");
        }
        
    }
    
    public List<TipoCama> obtenerTipoCama(){
        List<TipoCama> tipoCamas = new ArrayList<TipoCama>();  
        try {          
            String sql=("SELECT * FROM tipo_cama") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            TipoCama tipoCama;  
            while(rs.next()){   
              tipoCama= new TipoCama();
              tipoCama.setId_TipoCama(rs.getInt(1));
              
              TipoHabitacion tipoHabitacion=buscarTipoHabitacion(rs.getInt(2));   
              tipoCama.setTipoHabitacion(tipoHabitacion);
               
              tipoCama.setTipo(rs.getString(3));
                     
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar tipo cama" );
        }
        return tipoCamas;
    }
    
    
    public TipoCama buscarTipoCama(int id_TipoCama){     
        TipoCama tipoCama = null;                   
        try {
        String sql=("SELECT * FROM tipo_cama WHERE id_TipoCama=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_TipoCama);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            tipoCama= new TipoCama();       
            tipoCama.setId_TipoCama(rs.getInt(1));
            
            TipoHabitacion th=buscarTipoHabitacion(rs.getInt(2));
            tipoCama.setTipoHabitacion(th);
       
            tipoCama.setTipo(rs.getString(3));            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar tipo cama");
        }
        return tipoCama;      
        
    }
    public TipoHabitacion buscarTipoHabitacion(int id_TipoHab){     
       
        TipoHabitacionData thd= new TipoHabitacionData(conexion);    
        return thd.buscarTipoHabitacion(id_TipoHab);
    }
    
  
    public void actualizarTipoCama(TipoCama tipoCama){
        try {
            
            String sql=("UPDATE tipo_cama SET Tipo_habitacion=?, Tipo=?, WHERE id_Tipo_Cama=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, tipoCama.getTipoHabitacion().getId_TipoHab());
            ps.setString(2,tipoCama.getTipo());
            ps.setInt(3, tipoCama.getId_TipoCama());
               
            ps.executeUpdate(); 
                                
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR tipo cama ");
        }
        
    }
    
    
    public void borrarTipoCama(int id_TipoCama){
        try {
            String sql="DELETE FROM tipo_cama WHERE id_TipoCama=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_TipoCama);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR un tipo cama");
        }
    }
}

