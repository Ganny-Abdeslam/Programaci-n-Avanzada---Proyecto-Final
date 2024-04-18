package co.edu.uniquindio.dto;

import org.hibernate.validator.constraints.NotBlank;

public record EditarClienteDTO(
        @NotBlank(message = "Se necesita una cedula") String cedula,
        String nombre,
        String ciudad,
        String foto

) {
}
