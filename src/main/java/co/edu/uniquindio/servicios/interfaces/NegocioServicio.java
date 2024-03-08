package co.edu.uniquindio.servicios.interfaces;

public interface NegocioServicio {
    void crearNegocio();
    void actualizarNegocio();
    void buscarNegocios();
    void eliminarNegocio();
    void filtrarPorEstado();
    void listarNegociosPropietario();
    void cambiarEstado();
}
