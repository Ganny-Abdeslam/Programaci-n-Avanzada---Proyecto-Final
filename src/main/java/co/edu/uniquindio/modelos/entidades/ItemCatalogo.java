package co.edu.uniquindio.modelos.entidades;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCatalogo {
    private String nombreItem;
    private double precio;
    private String descripcion;
    private String foto;
}
