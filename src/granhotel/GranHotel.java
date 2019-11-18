
package granhotel;

import Modelo.HuespedData;
import Modelo.Huesped;
import Modelo.Conexion;
import Modelo.Habitacion;
import Modelo.HabitacionData;
import Modelo.TipoCama;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GranHotel {

    public static void main(String[] args) {
        try {
            Conexion con = new Conexion();
            
            Huesped h1 =new Huesped("Sebastian Salazar","mitre 234",24356745,15433243,"lascosta@gmail.com");
            HuespedData Hd= new HuespedData(con);
            //Hd.guardarHuesped(h1);
            //Hd.actualizarHuesped(h1);
            //Hd.borrarHuesped(3);
            
            Habitacion H1 = new Habitacion(1,123,true);
            HabitacionData HD = new HabitacionData(con);
            //HD.guardarHabitacion(H1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GranHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
