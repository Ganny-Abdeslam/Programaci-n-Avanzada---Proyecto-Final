package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelos.entidades.Horario;
import co.edu.uniquindio.modelos.entidades.Ubicacion;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RegistrarNegocioDTO(
        @NotBlank Ubicacion ubicacion,
        @NotBlank(message = "El nombre no puede estar en blanco") String nombre,
        String descripcion,
        @NotBlank List<Horario> horarios,
        @NotBlank String codTipoNegocio,
        List<String> imagenes,
        String cedulaCliente
) {
}
