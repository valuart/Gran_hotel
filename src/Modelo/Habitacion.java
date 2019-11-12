package Modelo;

/*Habitaciones numeradas del 1 al 200. Se encuentran en un piso, 
y tienen un estado Ocupada (1) o Libre (0).
 * and open the template in the editor.
 */

/**
 *
 * @author Vanesa
 */
public class Habitacion {
   private int id_habitacion;
   private int piso;
   private int numero;
   private String estado;
   
    public Habitacion() {
    }

    public Habitacion(int piso, int numero, String estado) {
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
    }

    public Habitacion(int id_habitacion, int piso, int numero, String estado) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
      public void cambiarEstado(){
      estado = (estado.equals("libre"))?"ocupada":"libre";
      }
}
