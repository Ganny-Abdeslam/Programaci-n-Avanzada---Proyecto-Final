package co.edu.uniquindio.modelos.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document("tipoNegocio")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoNegocio {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String valor;
    private int restriccion;
}
