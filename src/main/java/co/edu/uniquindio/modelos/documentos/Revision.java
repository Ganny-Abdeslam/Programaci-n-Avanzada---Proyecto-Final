package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("revision")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Revision {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @DBRef
    private Moderador codModerador;

    @DBRef
    private Negocio codNegocio;

    private String descripcion;
    private int estadoNegocio;
    private LocalDate fecha;
}
