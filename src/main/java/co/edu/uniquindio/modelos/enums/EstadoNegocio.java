package co.edu.uniquindio.modelos.enums;

public enum EstadoNegocio {
    NUEVO(0),
    APROBADO(1),
    PENDIENTE(2),
    RECHAZADO(3);

    private final int estado;

    EstadoNegocio(int estado){
        this.estado = estado;
    }

    public int getNumEstado(){
        return  estado;
    }
}
