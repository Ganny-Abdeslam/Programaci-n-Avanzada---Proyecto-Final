package co.edu.uniquindio.modelos.enums;

public enum Estado {
    SOLICITADO(0),
    ACTIVO(1),
    INACTIVO(2);

    private final int estado;

    Estado(int estado){
        this.estado = estado;
    }

    public int getNumEstado(){
        return  estado;
    }
}
