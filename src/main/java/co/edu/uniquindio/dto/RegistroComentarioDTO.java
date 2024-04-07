package co.edu.uniquindio.dto;

import java.time.LocalDate;

public record RegistroComentarioDTO(
        LocalDate fecha,
        int calificacion,
        String cedulaCliente,
        String codNegocio,
        String mensaje
) {
}
