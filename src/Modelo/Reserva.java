package Modelo;


import Modelo.Huesped;
import Modelo.Habitacion;
import java.time.LocalDate;

/*
 * Asi una reserva vincula un huésped con una habitación, 
y tiene fechas inicio y fin, días, un monto a pagar, un estado.  
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vanesa
 */
public class Reserva {
    private int id_reserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private double importe;
    private int cant_Pers;
    private LocalDate FechaIngreso;
    private LocalDate FechaEgreso;   

    public Reserva() {
    }

    public Reserva(Huesped huesped, Habitacion habitacion, double importe, int cant_Pers, LocalDate fechaIngreso, LocalDate fechaEgreso) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.importe = importe;
        this.cant_Pers = cant_Pers; 
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public Reserva(int id_Reserva, Huesped huesped, Habitacion habitacion, double importe, int cant_Pers, LocalDate fechaIngreso, LocalDate fechaEgreso) {
        this.id_Reserva= id_Reserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.importe = importe;
        this.cant_Pers = cant_Pers; 
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        
    }

    public int getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(int id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCant_Pers() {
        return cant_Pers;
    }

    public void setCant_Pers(int cant_Pers) {
        this.cant_Pers = cant_Pers;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    
}
