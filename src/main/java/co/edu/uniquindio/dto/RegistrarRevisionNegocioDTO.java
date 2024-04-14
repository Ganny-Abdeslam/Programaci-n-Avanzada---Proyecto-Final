package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelos.enums.EstadoNegocio;

import java.time.LocalDate;

public record RegistrarRevisionNegocioDTO(
        String codModerador,
        String codNegocio,
        String descripcion,
        EstadoNegocio estadoNegocio,
        LocalDate fecha
) {
}
