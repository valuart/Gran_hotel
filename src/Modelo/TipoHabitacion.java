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
    private int codigo;
    private int cantidadPersonas;
    private int cantidadCamas;
    private int precioHabitacion;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int cantidadPersonas, int cantidadCamas, int precioHabitacion) {
        this.cantidadPersonas = cantidadPersonas;
        this.cantidadCamas = cantidadCamas;
        this.precioHabitacion = precioHabitacion;
    }

    public TipoHabitacion(int codigo, int cantidadPersonas, int cantidadCamas, int precioHabitacion) {
        this.codigo = codigo;
        this.cantidadPersonas = cantidadPersonas;
        this.cantidadCamas = cantidadCamas;
        this.precioHabitacion = precioHabitacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
    
    public int getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(int precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    public void cambiarPrecio(){
       
    }

}