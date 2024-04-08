package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelos.entidades.Horario;
import co.edu.uniquindio.modelos.entidades.Ubicacion;

import java.util.List;

public record RegistrarNegocioDTO(
        Ubicacion ubicacion,
        String nombre,
        String descripcion,
        List<Horario> horarios,
        String codTipoNegocio,
        List<String> imagenes,
        String cedulaCliente
) {
}
