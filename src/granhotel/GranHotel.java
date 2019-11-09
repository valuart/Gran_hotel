/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel;

import Modelo.HuespedData;
import Modelo.Huesped;
import Modelo.Conexion;
/**
 *
 * @author Vanesa
 */
public class GranHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con =new Conexion();
        
        Huesped h1 =new Huesped("Sebastian Salazar","mitre 234",24356745,15433243,"lascosta@gmail.com");            
        HuespedData Hd= new HuespedData(con);
        Hd.guardarHuesped(h1);
          
    }
    
}
