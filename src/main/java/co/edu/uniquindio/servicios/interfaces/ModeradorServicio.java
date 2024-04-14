package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistrarRevisionNegocioDTO;

public interface ModeradorServicio {
    void aceptarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO);
    void rechazarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO);
}
