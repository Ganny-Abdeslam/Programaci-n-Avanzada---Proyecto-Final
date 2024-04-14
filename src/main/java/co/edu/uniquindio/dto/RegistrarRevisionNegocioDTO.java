package co.edu.uniquindio.dto;

import java.time.LocalDate;

public record RegistrarRevisionNegocioDTO(
        String codModerador,
        String codNegocio,
        String descripcion,
        LocalDate fecha
) {
}
