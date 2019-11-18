
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.Global.setDate;

public class ReservaData {
    private Connection con = null;
    private Conexion conexion;
    
    public ReservaData(Conexion conexion){
        try {
              con = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarReserva(Reserva reserva){
       
        String sql = "INSERT INTO reserva(huesped, habitacion, importe, cant_Pers, fechaIngreso, fechaEgreso) VALUES (?, ?, ?, ?, ?, ?)";
        try {
              PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
              ps.setInt(1,reserva.getHuesped().getId_huesped());
              ps.setInt(2,reserva.getHabitacion().getId_habitacion());
              ps.setDouble(3,reserva.getImporte());
              ps.setInt(4,reserva.getCant_Pers());
              ps.setDate(5,Date.valueOf(reserva.getFechaIngreso()));
              ps.setDate(6,Date.valueOf(reserva.getFechaEgreso()));
              
              ps.executeUpdate();
              ResultSet rs = ps.getGeneratedKeys();
              
              if(rs.next())
                  reserva.getId_reserva();
              else System.out.println("No se pudo obtener el id de la Reserva");
              
              ps.close();
              
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Reserva> obtenerReserva(){     
        List<Reserva> reservas = new ArrayList<Reserva>();          
        try {
               String sql = "SELECT * FROM reserva;";
               PreparedStatement ps = con.prepareStatement(sql) ;
               ResultSet rs = ps.executeQuery();
        
               Reserva reserva;       
                                               
               while(rs.next()){
                 reserva = new Reserva();       
                 reserva.setId_reserva(rs.getInt("Id_Reserva"));
                 
                 Huesped h = buscarHuesped(rs.getInt("Huesped"));
                 reserva.setHuesped(h);
          
                 Habitacion hab = buscarHabitacion(rs.getInt("Habitacion"));
                 reserva.setHabitacion(hab);
                 
                 reserva.setImporte(rs.getDouble("Importe"));
                 reserva.setCant_Pers(rs.getInt("Cant_Pers"));
                 reserva.setFechaIngreso(rs.getDate("FechaIngreso").toLocalDate());
                 reserva.setFechaEgreso(rs.getDate("FechaEgreso").toLocalDate());
                 
                 reservas.add(reserva);
                }
         
               ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar huesped");
        }
        return reservas;      
    }
    
    public Huesped buscarHuesped(int id){
        HuespedData hd = new HuespedData(conexion);
        return hd.buscarHuesped(id);
    }
    
    public Habitacion buscarHabitacion(int id){
        HabitacionData hd = new HabitacionData(conexion);
        return hd.buscarHabitacion(id);
    }
    
    public List<Reserva> obtenerReservasXHuesped(int id){
        List<Reserva> reservas = new ArrayList<Reserva>();          
        try {
               String sql = "SELECT * FROM reserva WHERE Huesped = ?;";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setInt(1, id);
               ResultSet rs = ps.executeQuery();
        
               Reserva reserva;       
                                               
               while(rs.next()){
                 reserva = new Reserva();       
                 reserva.setId_reserva(rs.getInt("Id_Reserva"));
                 
                 Huesped h = buscarHuesped(rs.getInt("Huesped"));
                 reserva.setHuesped(h);
          
                 Habitacion hab = buscarHabitacion(rs.getInt("Habitacion"));
                 reserva.setHabitacion(hab);
                 
                 reserva.setImporte(rs.getDouble("Importe"));
                 reserva.setCant_Pers(rs.getInt("Cant_Pers"));
                 reserva.setFechaIngreso(rs.getDate("FechaIngreso").toLocalDate());
                 reserva.setFechaEgreso(rs.getDate("FechaEgreso").toLocalDate());
                 
                 reservas.add(reserva);
                }
         
               ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar la reserva");
        }
        return reservas; 
    }
    
    public List<Reserva> obtenerReservasXFechas(LocalDate fecIng, LocalDate fecEg){
        List<Reserva> reservas = new ArrayList<Reserva>();          
        try {
               String sql = "SELECT * FROM reserva WHERE FechaIngreso = ? AND FechaEgreso = ?;";
               PreparedStatement ps = con.prepareStatement(sql);
               //ps.setInt(1, id);
               ResultSet rs = ps.executeQuery();
        
               Reserva reserva;       
                                               
               while(rs.next()){
                 reserva = new Reserva();       
                 reserva.setId_reserva(rs.getInt("Id_Reserva"));
                 
                 Huesped h = buscarHuesped(rs.getInt("Huesped"));
                 reserva.setHuesped(h);
          
                 Habitacion hab = buscarHabitacion(rs.getInt("Habitacion"));
                 reserva.setHabitacion(hab);
                 
                 reserva.setImporte(rs.getDouble("Importe"));
                 reserva.setCant_Pers(rs.getInt("Cant_Pers"));
                 reserva.setFechaIngreso(rs.getDate("FechaIngreso").toLocalDate());
                 reserva.setFechaEgreso(rs.getDate("FechaEgreso").toLocalDate());
                 
                 reservas.add(reserva);
                }
         
               ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar la reserva");
        }
        return reservas; 
    }
    
    public void borrarReservaXHuesped(int id){
        try {
            String sql = "DELETE FROM reserva WHERE Huesped = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarReservaXHabitacion(int id){
        try {
            String sql = "DELETE FROM reserva WHERE Habitacion = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarReserva(int idRes, int idHues, int idHab, double imp, int cp, LocalDate fecIng, LocalDate fecEg, int id_huesped ){
        try {
            String sql = "UPDATE reserva SET Cant_Pers = ?, FechaIngreso = ?, FechaEgreso = ? WHERE huesped = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            ps.setInt(1, idRes);
            ps.setInt(2, idHues);
            ps.setInt(3, idHab);
            ps.setDouble(4, imp);
            ps.setInt(5, cp);
            ps.setDate(6, Date.valueOf(fecIng));
            ps.setDate(7,Date.valueOf(fecEg));
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}