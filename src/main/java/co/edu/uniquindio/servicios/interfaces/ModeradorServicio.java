package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistrarRevisionNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;

import java.util.List;

public interface ModeradorServicio {
    void aceptarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO);
    void rechazarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO);

    List<Negocio> listarNegociosRechazados(String codigo);
    List<Negocio> listarNegociosAceptados(String codigo);
}
