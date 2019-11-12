/*
 * private int id_CantCam;
    private TipoCama TipoCama;
    private int cantidad;
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CantidadCamasData {
    Connection con= null;       
    Conexion conexion;
    
    public CantidadCamasData(Conexion conexion){
        con= conexion.getConexion();      
        this.conexion=conexion;
    }
    
    public void guardarCantidadCamas(CantidadCamas cantidadCamas){   
        String sql="INSERT INTO cantidad_camas(Tipo_Cama, Cantidad) VALUES (?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cantidadCamas.getTipoCama().getId_TipoCama());
                ps.setInt(2, cantidadCamas.getCantidad());
                                                        
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                     cantidadCamas.getId_CantCam(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID de la cantidad de camas " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar la cantidad de camas");
        }
        
    }
    
    public List<CantidadCamas> obtenerCantidadCamas(){
        List<CantidadCamas> cantidadDeCamas = new ArrayList<CantidadCamas>();  
        try {          
            String sql=("SELECT * FROM Cantidad_camas") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            CantidadCamas cantidadCamas;  
            while(rs.next()){   
            cantidadCamas= new CantidadCamas();
            cantidadCamas.setId_CantCam(rs.getInt(1));
              
            TipoCama tipoCama=buscarTipoCama(rs.getInt(2));   
            cantidadCamas.setTipoCama(tipoCama);
               
            cantidadCamas.setCantidad(rs.getInt(3));
                     
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar cantidad de camas" );
        }
        return cantidadDeCamas;
    }
    
    
    public CantidadCamas buscarCantidadCamas(int id_CantCam){     
        CantidadCamas cantidadCamas = null;                   
        try {
        String sql=("SELECT * FROM cantidad_camas WHERE id_CantCam=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_CantCam);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            cantidadCamas = new CantidadCamas();       
            cantidadCamas.setId_CantCam(rs.getInt(1));
            
            TipoCama tc=buscarTipoCama(rs.getInt(2));
            cantidadCamas.setTipoCama(tc);
       
            cantidadCamas.setCantidad(rs.getInt(3));            
        }
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar cantidad de camas");
        }
        return cantidadCamas;      
        
    }
    public TipoCama buscarTipoCama(int id_TipoCama){     
       
        TipoCamaData tcd= new TipoCamaData(conexion);    
        return tcd.buscarTipoCama(id_TipoCama);
    }
    
  
    public void actualizarCantidadCamas(CantidadCamas cantidadCamas){
        try {
            
            String sql=("UPDATE cantidad_camas SET Tipo_Cama=?, Cantidad=?, WHERE id_CantCam=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, cantidadCamas.getTipoCama().getId_TipoCama());
            ps.setInt(2, cantidadCamas.getCantidad());
            ps.setInt(3, cantidadCamas.getId_CantCam());
               
            ps.executeUpdate(); 
                                
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR la cantidad de camas ");
        }
        
    }
    
    
    public void borrarCantidadCamas(int id_CantCam){
        try {
            String sql="DELETE FROM cantidad_camas WHERE id_CantCam=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_CantCam);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR una cantidad de camas");
        }
    }
}
