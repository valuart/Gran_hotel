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
        
        con= conexion.getConexion();      
        
    }
    
    public void guardarHuesped(Huesped huesped){   
        String sql="INSERT INTO huesped(Nombre, Domicilio, Dni, Celular, Correo) VALUES (?,?,?,?,?)";
        
            try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1,huesped.getNombre());
                ps.setString(2,huesped.getDomicilio());
                ps.setInt(3,huesped.getDni());                                                       
                ps.setInt(4,huesped.getCelular());
                ps.setString(5,huesped.getCorreo()); 
                
                                                         
                ps.executeUpdate();     
                ResultSet rs= ps.getGeneratedKeys();    
                
                if(rs.next()){  
                    huesped.getId_huesped(); 
                    
                }else{
                    System.out.println("No se pudo obtener el ID del huesped " );
                }
                
                ps.close();
            
        }catch(SQLException ex){
                System.out.println("Error al ingresar el huesped");
        }
        
    }
    
    public List<Huesped> obtenerHuesped(){
        List<Huesped> huespedes = new ArrayList<Huesped>();  
        try {          
            String sql=("SELECT * FROM huesped") ;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();         
            
            Huesped huesped;  
            while(rs.next()){   
                huesped=new Huesped();        
                huesped.getId_huesped();
                huesped.setNombre(rs.getString(2));
                huesped.setDomicilio(rs.getString(3));
                huesped.setDni(rs.getInt(4));
                huesped.setCelular(rs.getInt(5));
                huesped.setCorreo(rs.getString(6));
                
                
                
                huespedes.add(huesped);       
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar huesped" );
        }
        return huespedes;
    }
    
    
    public Huesped buscarHuesped(int id_Huesped){     
        Huesped huesped = null;                   
        try {
        String sql=("SELECT * FROM huesped WHERE id_huesped=?");
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setInt(1, id_Huesped);                
        ResultSet rs= ps.executeQuery();       
                                               
        while(rs.next()){
            huesped= new Huesped();       
            huesped.getId_huesped();
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
        return huesped;      
        
    }
    
  
    public void actualizarHuesped(Huesped huesped){
        try {
            
            String sql=("UPDATE huesped SET nombre=?, dni=?, domicilio=?, correo=? , celular=?, WHERE id_huesped=?");
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getDomicilio());
            ps.setInt(3,huesped.getDni());
            ps.setInt(4, huesped.getCelular());
            ps.setString(5, huesped.getCorreo());
            ps.setInt(6, huesped.getId_huesped());
           
            
            ps.executeUpdate(); 
                                
            ps.close();
        } catch (SQLException ex) {
            
            System.out.println("Error al ACTUALIZAR huesped ");
        }
        
    }
    
    
    public void borrarHuesped(int id_huesped){
        try {
            String sql="DELETE FROM huesped WHERE id_huesped=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id_huesped);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("error al BORRAR un huesped");
        }
    }
}

