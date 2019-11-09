package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * TIPO CAMA=Simples, Queen, King Size)
 * and open the template in the editor.
 */

/**
 *
 * @author Vanesa
 */
public class TipoCama {
    private TipoHabitacion tipoHabitacion;
    private String simple;
    private String queen;
    private String kingSize;

    public TipoCama(TipoHabitacion tipoHabitacion, String simple, String queen, String kingSize) {
        this.tipoHabitacion = tipoHabitacion;
        this.simple = simple;
        this.queen = queen;
        this.kingSize = kingSize;
    }

    public TipoCama() {
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

    public String getQueen() {
        return queen;
    }

    public void setQueen(String queen) {
        this.queen = queen;
    }

    public String getKingSize() {
        return kingSize;
    }

    public void setKingSize(String kingSize) {
        this.kingSize = kingSize;
    }
    
    
}
