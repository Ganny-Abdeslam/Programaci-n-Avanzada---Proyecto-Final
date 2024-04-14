package co.edu.uniquindio.modelos.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("caatalogo")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Catalogo {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @DBRef
    private Negocio codNegocio;

    private List<String> fotos;
}
