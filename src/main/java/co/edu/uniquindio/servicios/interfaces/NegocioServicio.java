package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CambioEstadoDTO;
import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;

import java.util.List;

public interface NegocioServicio {
    void crearNegocio(RegistrarNegocioDTO registrarNegocioDTO) throws Exception;
    void actualizarNegocio();
    void buscarNegocios();
    void eliminarNegocio(String codNegocio);
    List<Negocio> filtrarPorEstado(int estado);
    List<Negocio> listarNegociosPropietario(String cedula);
    void cambiarEstado(CambioEstadoDTO cambioEstadoDTO) ;
}
