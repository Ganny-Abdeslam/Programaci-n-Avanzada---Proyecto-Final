package co.edu.uniquindio;

import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.repositorio.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrarClienteTest(){

        Cliente cliente = Cliente.builder()
                .cedula("1213444")
                .nombre("Pepito perez")
                .email("pepito@email.com")
                .foto("null")
                .estado(Estado.ACTIVO)
                .fechaNacimiento(LocalDate.of(2000, 2, 28))
                .nickname("peperez")
                .ciudad("Armenia")
                .password("password").build();

        Cliente registro = clienteRepo.save( cliente );
        Assertions.assertNotNull(registro);
    }
}
