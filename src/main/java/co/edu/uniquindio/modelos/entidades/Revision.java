package co.edu.uniquindio.modelos.entidades;

import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Revision {
    String descripcion;
    EstadoNegocio estadoNegocio;
    LocalDate fecha;
    String codModerador;
}
