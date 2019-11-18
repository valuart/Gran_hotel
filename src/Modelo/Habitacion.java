package Modelo;


public class Habitacion {
   private int id_habitacion;
   private int piso;
   private int numero;
   private boolean estado;
   
    public Habitacion() {
    }

    public Habitacion(int piso, int numero, boolean estado) {
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
    }

    public Habitacion(int id_habitacion, int piso, int numero, boolean estado) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }
    
      public void cambiarEstado(){
        if(estado)
            estado = false;
        else estado = true;
      }
}
