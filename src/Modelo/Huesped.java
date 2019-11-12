package Modelo;


/*
 *  Huésped tiene sus datos personales (nombre, DNI, Domicilio, correo, celular). 
 */

/**
 *
 * @author Vanesa
 */
public class Huesped { 
   private int id_huesped;
   private String nombre;
   private String domicilio;
   private int dni;
   private int celular;
   private String correo;
  

    public Huesped() {
    }

    public Huesped(String nombre, String domicilio, int dni, int celular, String correo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public Huesped(int id_huesped, String nombre, String domicilio, int dni, int celular, String correo) {
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId(int id) {
        this.id_huesped = id_huesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
   
}

