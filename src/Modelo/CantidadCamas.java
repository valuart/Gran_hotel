package Modelo;
public class CantidadCamas {
    private int id_CantCam;
    private TipoCama TipoCama;
    private int cantidad;

    public CantidadCamas() {
    }

    public CantidadCamas(TipoCama TipoCama, int cantidad) {
        this.TipoCama = TipoCama;
        this.cantidad = cantidad;
    }

    public CantidadCamas(int id_CantCam, TipoCama TipoCama, int cantidad) {
        this.id_CantCam = id_CantCam;
        this.TipoCama = TipoCama;
        this.cantidad = cantidad;
    }

    public int getId_CantCam() {
        return id_CantCam;
    }

    public void setId_CantCam(int id_CantCam) {
        this.id_CantCam = id_CantCam;
    }

    public TipoCama getTipoCama() {
        return TipoCama;
    }

    public void setTipoCama(TipoCama TipoCama) {
        this.TipoCama = TipoCama;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}