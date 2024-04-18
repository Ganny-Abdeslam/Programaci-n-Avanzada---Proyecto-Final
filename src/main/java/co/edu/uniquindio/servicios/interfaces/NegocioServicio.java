package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.modelos.documentos.Negocio;

import java.util.List;

public interface NegocioServicio {
    void crearNegocio(RegistrarNegocioDTO registrarNegocioDTO) throws Exception;
    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;
    List<Negocio> listarNegocios(String cedula);
    List<Negocio> negocioNombre(FiltroNombreDTO filtroNombreDTO);
    List<Negocio> negociosTipo(FiltroTipoDTO filtroTipoDTO);
    void eliminarNegocio(String codNegocio);
    List<Negocio> filtrarPorEstado(int estado);
    List<Negocio> listarNegociosPropietario(String cedula);
    void cambiarEstado(CambioEstadoDTO cambioEstadoDTO) throws Exception;
    Negocio traerNegocio(String codNegocio) throws Exception;
}
