package co.edu.uniquindio.modelo;

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
