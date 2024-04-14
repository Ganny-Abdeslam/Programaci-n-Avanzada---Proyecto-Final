package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.ListarRevisionesDTO;
import co.edu.uniquindio.modelos.documentos.Revision;
import co.edu.uniquindio.repositorio.RevisionRepo;
import co.edu.uniquindio.servicios.interfaces.RevisionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SpringBootApplication
public class RevisionImplementacion implements RevisionServicio {

    @Autowired
    RevisionRepo revisionRepo;
    @Override
    public List<Revision> listarPorEstado(ListarRevisionesDTO listarRevisionesDTO) {

        return revisionRepo.estadoNegocioAndCodModerador(
                listarRevisionesDTO.estadoNegocio(),
                listarRevisionesDTO.codModerador()
        );
    }
}
