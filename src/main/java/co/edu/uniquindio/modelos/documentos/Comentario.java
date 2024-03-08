package co.edu.uniquindio.modelos.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

@Document("comentario")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private LocalDate fecha;
    private int calificacion;
    private String cedulaCliente;
    private int codNegocio;
    private String mensaje;
    private String respuesta;
}
