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
public class Cantidad_Camas {
    private int id_CantCam;
    private TipoCama TipoCama;
    private int cantidad;

    public Cantidad_Camas() {
    }

    public Cantidad-Camas(int id_CantCam, TipoCama tipoCama, int cantidad) {
        this.id_CantCam = id_CantCam;
        this.tipoCama = tipoCama;
        this.cantidad = cantidad;
    }

    public int getId_CantCam() {
        return id_CantCam;
    }

    public void setId_CantCam(int id_CantCam) {
        this.id_CantCam = id_CantCam;
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
      
}
