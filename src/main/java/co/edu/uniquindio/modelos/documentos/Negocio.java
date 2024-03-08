package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.entidades.Horario;
import co.edu.uniquindio.modelos.entidades.Revision;
import co.edu.uniquindio.modelos.entidades.Ubicacion;
import co.edu.uniquindio.modelos.enums.Estado;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("negocio")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Negocio {
    @Id
    @EqualsAndHashCode.Include
    int codigo;

    Ubicacion ubicacion;
    String nombre;
    String descripcion;
    List<Horario> horarios;
    int codTipoNegocio;
    Estado estado;
    List<String> imagenes;
    String cedulaCliente;
    List<Revision> revisiones;
}
