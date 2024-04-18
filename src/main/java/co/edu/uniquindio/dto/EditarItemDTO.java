package co.edu.uniquindio.dto;

public record EditarItemDTO(
        String nombre,
        double precio,
        String descripcion,
        String foto,
        String codCatalogo
) {
}
