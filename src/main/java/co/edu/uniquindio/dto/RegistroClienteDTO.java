package co.edu.uniquindio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

public record RegistroClienteDTO(

        @Email(message =  "Por favor ingrese un eemail valido")
        @NotBlank(message = "El email no puede estar en blanco")
        String email,
        @NotBlank(message = "El nombre no puede estar en blanco") String nombre,
        @NotBlank(message = "La contraseña no puede estar en blanco") String password,
        @NotBlank(message = "La cedula no puede estar en blanco") String cedula,
        @NotBlank(message = "El nickname no puede estar en blanco") String nickname,
        @NotNull(message = "La fecha de nacimiento no puede estar en blanco")
        @Past(message = "La fecha de nacimiento debe estar en el pasado") LocalDate fechaNacimiento,
        String ciudad,
        String foto
) {
}