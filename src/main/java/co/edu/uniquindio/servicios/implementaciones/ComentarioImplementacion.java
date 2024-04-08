package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.modelos.documentos.Comentario;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.ComentarioRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.servicios.interfaces.ComentariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
public class ComentarioImplementacion implements ComentariosServicio {

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private NegocioRepo negocioRepo;

    @Override
    public String crearComentario(RegistroComentarioDTO registroComentarioDTO) throws Exception {

        if ( !existeCedula(registroComentarioDTO.cedulaCliente()) ){
            throw new Exception("La cedula no existe");
        }

        /*if ( !existeNegocio(registroComentarioDTO.codNegocio()) ){
            throw new Exception("El negocio no existe");
        }*/

        Comentario comentario = new Comentario();

        comentario.setCalificacion(registroComentarioDTO.calificacion());
        comentario.setFecha(registroComentarioDTO.fecha());
        comentario.setCedulaCliente(registroComentarioDTO.cedulaCliente());
        comentario.setCodNegocio(registroComentarioDTO.codNegocio());
        comentario.setMensaje(registroComentarioDTO.mensaje());

        Comentario nuevoComentario = comentarioRepo.save(comentario);

        return nuevoComentario.getCodigo();
    }

    @Override
    public List<Comentario> listarComentariosNegocio(String codNegocio) {
        List<Comentario> comentarioList = comentarioRepo.listaComentariosNegocio(codNegocio);
        return comentarioList;
    }

    @Override
    public void responderComentario(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        if ( !existeCedula(registroRespuestaDTO.cedulaCliente()) ){
            throw new Exception("La cedula no existe");
        }

        /*if ( !existeNegocio(registroRespuestaDTO.codNegocio()) ){
            throw new Exception("El negocio no existe");
        }*/

        if ( !existeIdComentario(registroRespuestaDTO.idComentarioOrigen()) ){
            throw new Exception("El comentario no existe");
        }

        String idRespuesta = this.crearComentario(new RegistroComentarioDTO(
                                                            registroRespuestaDTO.fecha(),
                                                            0,
                                                            registroRespuestaDTO.cedulaCliente(),
                                                            registroRespuestaDTO.codNegocio(),
                                                            registroRespuestaDTO.mensaje()));

        Comentario comentarioOrigen = comentarioRepo.findById(registroRespuestaDTO.idComentarioOrigen()).orElse(null);

        comentarioOrigen.setRespuesta(idRespuesta);

        comentarioRepo.save(comentarioOrigen);
    }

    private boolean existeCedula( String cedula ){
        return clienteRepo.findById(cedula).isPresent();
    }

    private boolean existeNegocio( String negocio ){
        return negocioRepo.findById(negocio).isPresent();
    }

    private boolean existeIdComentario( String idComentario ){
        return comentarioRepo.findById(idComentario).isPresent();
    }
}
