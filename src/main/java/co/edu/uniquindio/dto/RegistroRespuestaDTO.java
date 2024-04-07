package co.edu.uniquindio.dto;

import java.time.LocalDate;

public record RegistroRespuestaDTO(
        LocalDate fecha,
        String cedulaCliente,
        String codNegocio,
        String mensaje,
        String idComentarioOrigen
) {
}
