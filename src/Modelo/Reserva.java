package Modelo;


import Modelo.Huesped;
import Modelo.Habitacion;
import java.time.LocalDate;

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

    public Reserva(Huesped huesped, Habitacion habitacion, double importe, int cant_Pers, LocalDate FechaIngreso, LocalDate FechaEgreso) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.importe = importe;
        this.cant_Pers = cant_Pers;
        this.FechaIngreso = FechaIngreso;
        this.FechaEgreso = FechaEgreso;
    }

    public Reserva(int id_reserva, Huesped huesped, Habitacion habitacion, double importe, int cant_Pers, LocalDate FechaIngreso, LocalDate FechaEgreso) {
        this.id_reserva = id_reserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.importe = importe;
        this.cant_Pers = cant_Pers;
        this.FechaIngreso = FechaIngreso;
        this.FechaEgreso = FechaEgreso;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
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
        return FechaIngreso;
    }

    public void setFechaIngreso(LocalDate FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return FechaEgreso;
    }

    public void setFechaEgreso(LocalDate FechaEgreso) {
        this.FechaEgreso = FechaEgreso;
    }

    
}
