package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.modelos.documentos.Moderador;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.Revision;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import co.edu.uniquindio.repositorio.RevisionRepo;
import co.edu.uniquindio.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SpringBootApplication
@AllArgsConstructor
public class ModeradorImplementacion implements ModeradorServicio {

    final private RevisionRepo revisionRepo;
    final private NegocioImplementacion negocioImplementacion;
    final private RevisionImplementacion revisionImplementacion;

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

        revisionRepo.save(revision);

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

        revisionRepo.save(revision);

        negocioImplementacion.cambiarEstado(new CambioEstadoDTO(negocio.getCodigo(), Estado.RECHAZADO));
    }

    @Override
    public List<Negocio> listarNegociosRechazados(String codigo) {
        List<Revision> revisiones = revisionImplementacion.listarPorEstado(new ListarRevisionesDTO(codigo, 3));
        List<Negocio> negocios = new ArrayList<>();

        for (Revision r: revisiones){
            negocios.add(r.getCodNegocio());
        }

        return negocios;
    }

    @Override
    public List<Negocio> listarNegociosAceptados(String codigo) {
        List<Revision> revisiones = revisionImplementacion.listarPorEstado(new ListarRevisionesDTO(codigo, 1));
        List<Negocio> negocios = new ArrayList<>();

        for (Revision r: revisiones){
            negocios.add(r.getCodNegocio());
        }

        return negocios;
    }

}
