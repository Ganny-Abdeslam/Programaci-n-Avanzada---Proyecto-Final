package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.modelos.documentos.Comentario;

import java.util.List;

public interface ComentariosServicio {
    String crearComentario(RegistroComentarioDTO registroComentarioDTO) throws Exception;
    List<Comentario> listarComentariosNegocio(String codNegocio);
    void responderComentario(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;
}
