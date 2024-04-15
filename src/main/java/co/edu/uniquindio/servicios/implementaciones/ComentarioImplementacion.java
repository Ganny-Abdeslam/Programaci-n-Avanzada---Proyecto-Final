package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.EmailDTO;
import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.documentos.Comentario;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.ComentarioRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.servicios.interfaces.ComentariosServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
@RequiredArgsConstructor
public class ComentarioImplementacion implements ComentariosServicio {

    final private ComentarioRepo comentarioRepo;
    final private ClienteRepo clienteRepo;
    final private NegocioRepo negocioRepo;
    final private EmailImplementacion emailImplementacion;

    @Override
    public Comentario crearComentario(RegistroComentarioDTO registroComentarioDTO) throws Exception {

        if ( !existeCedula(registroComentarioDTO.cedulaCliente()) ){
            throw new Exception("La cedula no existe");
        }

        if ( !existeNegocio(registroComentarioDTO.codNegocio()) ){
            throw new Exception("El negocio no existe");
        }

        Comentario comentario = crearComentarioLocal(registroComentarioDTO);

        enviarCorreo(negocioRepo.findById(registroComentarioDTO.codNegocio()).orElse(null).getCedulaCliente(),
                "Creo un comentario para su negocio: "+
                        negocioRepo.findById(registroComentarioDTO.codNegocio()).orElse(null).getNombre(),
                registroComentarioDTO.mensaje());
        return comentario;
    }

    private Comentario crearComentarioLocal(RegistroComentarioDTO registroComentarioDTO){
        Comentario comentario = new Comentario();

        Negocio negocio = new Negocio();
        Cliente cliente = new Cliente();

        negocio.setCodigo(registroComentarioDTO.codNegocio());
        cliente.setCedula(registroComentarioDTO.cedulaCliente());

        comentario.setCalificacion(registroComentarioDTO.calificacion());
        comentario.setFecha(registroComentarioDTO.fecha());
        comentario.setCedulaCliente(cliente);
        comentario.setCodNegocio(negocio);
        comentario.setMensaje(registroComentarioDTO.mensaje());

        return comentarioRepo.save(comentario);
    }

    private void enviarCorreo(Cliente cliente, String asunto, String cuerpo) throws Exception {
        emailImplementacion.enviarCorreo(new EmailDTO(asunto, cuerpo, cliente.getEmail()));
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

        if ( !existeNegocio(registroRespuestaDTO.codNegocio()) ){
            throw new Exception("El negocio no existe");
        }

        if ( !existeIdComentario(registroRespuestaDTO.idComentarioOrigen()) ){
            throw new Exception("El comentario no existe");
        }

        Comentario idRespuesta = this.crearComentarioLocal(new RegistroComentarioDTO(
                                                            registroRespuestaDTO.fecha(),
                                                            0,
                                                            registroRespuestaDTO.cedulaCliente(),
                                                            registroRespuestaDTO.codNegocio(),
                                                            registroRespuestaDTO.mensaje()));

        Comentario comentarioOrigen = comentarioRepo.findById(registroRespuestaDTO.idComentarioOrigen()).orElse(null);

        comentarioOrigen.setIdRespuesta(idRespuesta);

        enviarCorreo(comentarioOrigen.getCedulaCliente(),
                "Le enviaron una respuesta para su comentario, por el negocio: "+
                        negocioRepo.findById(registroRespuestaDTO.codNegocio()).orElse(null).getNombre(),
                registroRespuestaDTO.mensaje());

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
