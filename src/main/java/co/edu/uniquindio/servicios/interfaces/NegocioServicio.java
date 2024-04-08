package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistrarNegocioDTO;

public interface NegocioServicio {
    void crearNegocio(RegistrarNegocioDTO registrarNegocioDTO) throws Exception;
    void actualizarNegocio();
    void buscarNegocios();
    void eliminarNegocio();
    void filtrarPorEstado();
    void listarNegociosPropietario();
    void cambiarEstado();
}
