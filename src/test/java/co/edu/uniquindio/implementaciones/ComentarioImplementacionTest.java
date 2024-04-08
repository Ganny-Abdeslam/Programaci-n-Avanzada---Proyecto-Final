package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.RegistroComentarioDTO;
import co.edu.uniquindio.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.servicios.implementaciones.ComentarioImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ComentarioImplementacionTest {

    @Autowired
    ComentarioImplementacion comentarioImplementacion;

    @Test
    public void crearComentarioTest() throws Exception {

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroComentarioDTO registroComentarioDTO = new RegistroComentarioDTO(fecha,4,
                "111122224","1","Esto es un comentario"
        );

        Assertions.assertNotNull(comentarioImplementacion.crearComentario(registroComentarioDTO));

    }

    @Test
    public void responderComentarioTest() throws Exception {

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(fecha,
                "111122224","1","Esto es una respuesta","6612f4391a2f75611c62468b"
        );

        comentarioImplementacion.responderComentario(registroRespuestaDTO);

    }
}
