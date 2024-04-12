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
                "111122224","661333c59f5d583c903e7ba2","Esto es un comentario"
        );

        Assertions.assertNotNull(comentarioImplementacion.crearComentario(registroComentarioDTO));

    }

    @Test
    public void responderComentarioTest() throws Exception {

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(fecha,
                "111122224","661333c59f5d583c903e7ba2","Esto es una respuesta","66135b7f23004d5639656b5d"
        );

        comentarioImplementacion.responderComentario(registroRespuestaDTO);

    }

    @Test
    public void listarComentariosNegocioTest(){
        Assertions.assertEquals(4,comentarioImplementacion.listarComentariosNegocio("1").toArray().length);
    }
}
