package co.edu.uniquindio.documentos;

import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import co.edu.uniquindio.modelos.entidades.Ubicacion;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.repositorio.TipoNegocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class NegocioTest {

    @Autowired
    private NegocioRepo negocioRepo;
    @Autowired
    private TipoNegocioRepo tipoNegocioRepo;
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrarNegocio(){

        TipoNegocio tipoNegocio = tipoNegocioRepo.findById("12345").orElse(null);
        Cliente cliente = clienteRepo.findById("1213444").orElse(null);

        Negocio negocio = new Negocio(
                "123456789",
                tipoNegocio,
                cliente,new Ubicacion(1.2, 2.4),
                "Nombre negocio doc test",
                "Esta es la descripción del negocio",
                new ArrayList<>(),
                0,
                new ArrayList<>(),
                new ArrayList<>()
        );

        Negocio registro = negocioRepo.save( negocio );
        Assertions.assertNotNull(registro);

    }

    @Test
    public void consultarNegocioTest(){
        Negocio negocio = negocioRepo.findById("123456789").orElse(null);

        Assertions.assertNotNull(negocio);
    }

}
