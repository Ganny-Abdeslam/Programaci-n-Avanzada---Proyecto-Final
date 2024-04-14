package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelos.enums.Estado;

public record CambioEstadoDTO(
        String id,
        Estado estado
) {
}
