package co.edu.uniquindio.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

public record RegistroUsuarioDTO(
        String email,
        @NotBlank String nombre,
        String password,
        String cedula,
        String nickname,
        LocalDate fechaNacimiento,
        String ciudad,
        String foto
) {
}