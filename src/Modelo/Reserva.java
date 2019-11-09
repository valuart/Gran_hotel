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
    private int id;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate checkIn;
    private LocalDate checkOut;   

    public Reserva() {
    }

    public Reserva(Huesped huesped, Habitacion habitacion, LocalDate checkIn, LocalDate checkOut) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reserva(int id, Huesped huesped, Habitacion habitacion, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    
    
    
    
}
