package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.ListarRevisionesDTO;
import co.edu.uniquindio.servicios.implementaciones.RevisionImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RevisionImplementacionTest {
    @Autowired
    RevisionImplementacion revisionImplementacion;
    @Test
    public void listarPorEstadoTest(){

        ListarRevisionesDTO listarRevisionesDTO = new ListarRevisionesDTO(
                "1234","1"
        );

        Assertions.assertEquals(2,revisionImplementacion.listarPorEstado(listarRevisionesDTO).toArray().length);
    }
}
