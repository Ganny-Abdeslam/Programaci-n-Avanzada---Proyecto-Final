package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.entidades.Horario;
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
    private String codigo;

    private Ubicacion ubicacion;
    private String nombre;
    private String descripcion;
    private List<Horario> horarios;
    private int codTipoNegocio;
    private Estado estado;
    private List<String> imagenes;
    private String cedulaCliente;
    private List<Revision> revisiones;
}
