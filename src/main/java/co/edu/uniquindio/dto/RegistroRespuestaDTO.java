package co.edu.uniquindio.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegistroRespuestaDTO(
        @NotBlank LocalDate fecha,
        @NotBlank String cedulaCliente,
        @NotBlank String codNegocio,
        String mensaje,
        @NotBlank String idComentarioOrigen
) {
}
