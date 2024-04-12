package co.edu.uniquindio.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

public record RegistroComentarioDTO(
        @NotBlank LocalDate fecha,
        @NotBlank int calificacion,
        @NotBlank String cedulaCliente,
        @NotBlank String codNegocio,
        String mensaje
) {
}
