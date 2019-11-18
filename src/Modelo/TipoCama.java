package Modelo;

public class TipoCama {
    private int id_TipoCama;
    private TipoHabitacion tipoHabitacion;
    private String tipo;
    
     public TipoCama() {
    }

    public TipoCama(TipoHabitacion tipoHabitacion, String tipo) {
        this.tipoHabitacion = tipoHabitacion;
        this.tipo = tipo;
    }

    public TipoCama(int id_TipoCama, TipoHabitacion tipoHabitacion, String tipo) {
        this.id_TipoCama = id_TipoCama;
        this.tipoHabitacion = tipoHabitacion;
        this.tipo = tipo;    
    }

    public int getId_TipoCama() {
        return id_TipoCama;
    }
    
    public void setId_TipoCama(int id_TipoCama) {
        this.id_TipoCama = id_TipoCama;
    }
    
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
