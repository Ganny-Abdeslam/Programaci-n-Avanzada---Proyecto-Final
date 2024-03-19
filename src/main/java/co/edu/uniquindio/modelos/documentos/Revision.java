package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Revision {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String descripcion;
    private EstadoNegocio estadoNegocio;
    private LocalDate fecha;
    private String codModerador;
}
