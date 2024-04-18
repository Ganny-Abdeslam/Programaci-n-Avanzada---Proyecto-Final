package co.edu.uniquindio.documentos;

import co.edu.uniquindio.modelos.documentos.Catalogo;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.documentos.Comentario;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.ComentarioRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class CometarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private NegocioRepo negocioRepo;

    @Test
    public void registrarComentario(){

        Cliente cliente = clienteRepo.findById("1213444").orElse(null);

        Negocio negocio = negocioRepo.findById("661c0fabd1eaaa54c9d6098e").orElse(null);

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        Comentario comentario = new Comentario(
                "465789",
                cliente,
                negocio,
                null,
                fecha,
                4,
                "esto es un comentario"
        );

        Comentario registro = comentarioRepo.save( comentario );
        Assertions.assertNotNull(registro);
    }

    @Test
    public void consultarComentarioTest(){
        Comentario comentario = comentarioRepo.findById("12345").orElse(null);

        Assertions.assertNotNull(comentario);
    }
}
