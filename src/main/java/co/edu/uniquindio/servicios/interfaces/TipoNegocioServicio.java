package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.TipoNegocioDTO;
import co.edu.uniquindio.modelos.documentos.TipoNegocio;

import java.util.List;

public interface TipoNegocioServicio {
    List<TipoNegocio> traerTipoNegocios();

    void agregarTipo(TipoNegocioDTO tipoNegocioDTO);
}
