package co.edu.uniquindio.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public record EmailDTO(
        @NotBlank(message = "El asunto no puede estar en blanco")String asunto,
        String cuerpo,
        @NotBlank(message = "El destinatario no puede estar en blanco") String destinatario) {
}
