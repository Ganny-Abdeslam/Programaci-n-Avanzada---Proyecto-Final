package co.edu.uniquindio.modelos.documentos;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document("tipoNegocio")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoNegocio {
}
