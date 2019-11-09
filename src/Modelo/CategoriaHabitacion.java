package Modelo;

/*
 * (Estándar simple, doble, Triple, o Suite Lujo) 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vanesa
 */
public class CategoriaHabitacion {
    private TipoHabitacion tipoHabitacion;
    private String simple;
    private String doble;
    private String triple;
    private String lujo;   

    public CategoriaHabitacion() {
    }

    public CategoriaHabitacion(TipoHabitacion tipoHabitacion, String simple, String doble, String triple, String lujo) {
        this.tipoHabitacion = tipoHabitacion;
        this.simple = simple;
        this.doble = doble;
        this.triple = triple;
        this.lujo = lujo;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public String getDoble() {
        return doble;
    }

    public void setDoble(String doble) {
        this.doble = doble;
    }

    public String getTriple() {
        return triple;
    }

    public void setTriple(String triple) {
        this.triple = triple;
    }

    public String getLujo() {
        return lujo;
    }

    public void setLujo(String lujo) {
        this.lujo = lujo;
    }
    
    
}
