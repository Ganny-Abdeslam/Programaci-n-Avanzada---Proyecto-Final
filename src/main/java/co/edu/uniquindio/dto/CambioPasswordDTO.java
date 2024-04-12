package co.edu.uniquindio.dto;

import org.hibernate.validator.constraints.NotBlank;

public record CambioPasswordDTO (
        @NotBlank(message = "La contraseña no puede estar en blanco")String password
){
}
