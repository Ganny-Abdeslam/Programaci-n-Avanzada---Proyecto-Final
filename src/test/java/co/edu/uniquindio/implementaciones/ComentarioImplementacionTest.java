package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.servicios.implementaciones.ComentarioImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
public class ComentarioImplementacionTest {

    @Autowired
    ComentarioImplementacion comentarioImplementacion;

    @Test
    public void crearComentarioTest() throws Exception {

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroComentarioDTO registroComentarioDTO = new RegistroComentarioDTO(fecha,4,
                "1213444","661c0d040359df17bc0a9a59","Esto es un comentario"
        );

        Assertions.assertNotNull(comentarioImplementacion.crearComentario(registroComentarioDTO));

    }

    @Test
    public void responderComentarioTest() throws Exception {

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(fecha,
                "1213444","661c0d040359df17bc0a9a59","Esto es una respuesta","661ca6a8fc4b015ead4fe03a"
        );

        comentarioImplementacion.responderComentario(registroRespuestaDTO);

    }

    @Test
    public void listarComentariosNegocioTest(){
        Assertions.assertEquals(5,comentarioImplementacion.listarComentariosNegocio("661c0d040359df17bc0a9a59").toArray().length);
    }
}
