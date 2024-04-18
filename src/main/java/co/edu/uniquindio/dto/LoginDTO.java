package co.edu.uniquindio.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public record LoginDTO(
        @Email(message =  "Por favor ingrese un eemail valido")
        @NotBlank(message = "El email no puede estar en blanco")
        String email,
        @NotBlank(message = "La contraseña no puede estar en blanco")String password
) {
}
