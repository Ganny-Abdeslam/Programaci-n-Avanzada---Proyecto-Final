package co.edu.uniquindio.documentos;


import co.edu.uniquindio.modelos.documentos.Catalogo;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.repositorio.CatalogoRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class CatalogoTest {

    @Autowired
    private CatalogoRepo catalogoRepo;
    @Autowired
    private NegocioRepo negocioRepo;

    @Test
    public void registrarCatalogo() {

        Negocio negocio = negocioRepo.findById("661c0fabd1eaaa54c9d6098e").orElse(null);

        Catalogo catalogo = new Catalogo("12345",negocio, new ArrayList<>());

        Catalogo registro = catalogoRepo.save(catalogo);

        Assertions.assertNotNull(registro);

    }

    @Test
    public void consultarCatalogoTest(){
        Catalogo catalogo = catalogoRepo.findById("12345").orElse(null);

        Assertions.assertNotNull(catalogo);
    }
}
