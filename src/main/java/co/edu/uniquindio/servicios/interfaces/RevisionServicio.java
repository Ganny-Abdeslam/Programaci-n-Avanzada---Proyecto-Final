package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.ListarRevisionesDTO;
import co.edu.uniquindio.modelos.documentos.Revision;
import java.util.List;

public interface RevisionServicio {
    List<Revision> listarPorEstado(ListarRevisionesDTO listarRevisionesDTO);
}
