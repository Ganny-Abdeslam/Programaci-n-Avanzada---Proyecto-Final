package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.CambioEstadoDTO;
import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistrarRevisionNegocioDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;
import co.edu.uniquindio.modelos.documentos.Moderador;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.Revision;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import co.edu.uniquindio.repositorio.RevisionRepo;
import co.edu.uniquindio.servicios.interfaces.ModeradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication
public class ModeradorImplementacion implements ModeradorServicio {

    @Autowired
    RevisionRepo revisionRepo;

    @Autowired
    NegocioImplementacion negocioImplementacion;

    @Override
    public void aceptarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO) {

        Moderador moderador = new Moderador();
        moderador.setCodigo(registrarRevisionNegocioDTO.codModerador());
        Negocio negocio = new Negocio();
        negocio.setCodigo(registrarRevisionNegocioDTO.codNegocio());

        Revision revision = new Revision();
        revision.setCodNegocio(negocio);
        revision.setCodModerador(moderador);
        revision.setFecha(registrarRevisionNegocioDTO.fecha());
        revision.setEstadoNegocio(EstadoNegocio.APROBADO.getNumEstado());


        Revision revisionGuardada = revisionRepo.save(revision);

        negocioImplementacion.cambiarEstado(new CambioEstadoDTO(negocio.getCodigo(), Estado.ACTIVO));

    }

    @Override
    public void rechazarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO) {

        Moderador moderador = new Moderador();
        moderador.setCodigo(registrarRevisionNegocioDTO.codModerador());
        Negocio negocio = new Negocio();
        negocio.setCodigo(registrarRevisionNegocioDTO.codNegocio());

        Revision revision = new Revision();
        revision.setCodNegocio(negocio);
        revision.setCodModerador(moderador);
        revision.setFecha(registrarRevisionNegocioDTO.fecha());
        revision.setDescripcion(registrarRevisionNegocioDTO.descripcion());
        revision.setEstadoNegocio(EstadoNegocio.RECHAZADO.getNumEstado());

        Revision revisionGuardada = revisionRepo.save(revision);

        negocioImplementacion.cambiarEstado(new CambioEstadoDTO(negocio.getCodigo(), Estado.RECHAZADO));
    }
}
