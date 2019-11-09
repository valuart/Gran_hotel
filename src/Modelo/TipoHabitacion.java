package Modelo;



/**	Crear la Clase Tipo de Habitación tendrá sus propias características, 
 * las relevantes para nuestro sistema de gestión de reservas son: código, 
 * cantidad de personas (maxima), cantidad de camas, tipo de camas (Simples, Queen, King Size),
 * precio por noche, que por simplicidad se supondrá único (sin promociones o tarifas 
 * distintas para temporada alta o baja). 
 *
 * @author Vanesa
 */
public class TipoHabitacion {
    private int id_TipoHab;
    private TipoCama tipoCama;
    private Habitacion habitacion;
    private String descripcion;
    private double precio;

    public TipoHabitacion() {
    }

    public TipoHabitacion(TipoCama tipoCama, Habitacion habitacion, String descripcion, double precio) {
        this.tipoCama = tipoCama;
        this.habitacion = habitacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public TipoHabitacion(int id_TipoHab, TipoCama tipoCama, Habitacion habitacion, String descripcion, double precio) {
        this.id_TipoHab = id_TipoHab;
        this.tipoCama = tipoCama;
        this.habitacion = habitacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId_TipoHab() {
        return id_TipoHab;
    }

    public void setId_TipoHab(int id_TipoHab) {
        this.id_TipoHab = id_TipoHab;
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void cambiarPrecio(double precioNuevo){
       precio = nuevoPrecio;
    }

}
