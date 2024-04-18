package co.edu.uniquindio.documentos;

import co.edu.uniquindio.modelos.documentos.Moderador;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.Revision;
import co.edu.uniquindio.repositorio.ModeradorRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.repositorio.RevisionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class RevisionTest {

    @Autowired
    private RevisionRepo revisionRepo;
    @Autowired
    private ModeradorRepo moderadorRepo;
    @Autowired
    private NegocioRepo negocioRepo;


    @Test
    public void registrarRevisionTest(){

        Moderador moderador = moderadorRepo.findById("1234").orElse(null);
        Negocio negocio = negocioRepo.findById("123456789").orElse(null);

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        Revision revision = new Revision(
                "264810",
                moderador,
                negocio,
                "Esta es la descripcion de la rvision",
                1,
                fecha
        );

        Revision registro = revisionRepo.save( revision );
        Assertions.assertNotNull(registro);
    }

    @Test
    public void consultarRevisionTest(){
        Revision revision = revisionRepo.findById("264810").orElse(null);

        Assertions.assertNotNull(revision);
    }
}
