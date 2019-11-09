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
   private int id;
   private String estado;
   private String tipoCama;
   private String tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(String estado, String tipoCama, String tipoHabitacion) {
        this.estado = estado;
        this.tipoCama = tipoCama;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion(int id, String estado, String tipoCama, String tipoHabitacion) {
        this.id = id;
        this.estado = estado;
        this.tipoCama = tipoCama;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

      public void cambiarEstado(){
      estado = (estado.equals("libre"))?"ocupada":"libre";
      }
}
