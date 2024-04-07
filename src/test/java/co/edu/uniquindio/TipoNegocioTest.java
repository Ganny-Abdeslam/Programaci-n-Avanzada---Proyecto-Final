package co.edu.uniquindio;

import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import co.edu.uniquindio.repositorio.TipoNegocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoNegocioTest {
    @Autowired
    private TipoNegocioRepo tipoNegocioRepo;

    @Test
    public void registrarTipoNegocioTest(){

        TipoNegocio tipoNegocio = TipoNegocio.builder()
                .codigo("12345")
                .valor("0")
                .restriccion(0).build();

        TipoNegocio registro = tipoNegocioRepo.save( tipoNegocio );
        Assertions.assertNotNull(registro);
    }

    @Test
    public void consultarTipoNegocioTest(){
        TipoNegocio tipoNegocio = tipoNegocioRepo.findById("12345").orElse(null);

        Assertions.assertNotNull(tipoNegocio);
    }
}
