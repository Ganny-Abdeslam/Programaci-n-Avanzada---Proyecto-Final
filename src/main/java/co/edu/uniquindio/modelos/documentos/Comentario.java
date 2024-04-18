package co.edu.uniquindio.modelos.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document("comentario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @DBRef
    private Cliente cedulaCliente;

    @DBRef
    private Negocio codNegocio;

    @DBRef
    private Comentario idRespuesta;

    private LocalDate fecha;
    private int calificacion;
    private String mensaje;
}
