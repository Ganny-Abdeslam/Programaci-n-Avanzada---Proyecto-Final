package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;

public interface ComentariosServicio {
    String crearComentario(RegistroComentarioDTO registroComentarioDTO) throws Exception;
    void listarComentariosNegocio();
    void responderComentario(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;
}
