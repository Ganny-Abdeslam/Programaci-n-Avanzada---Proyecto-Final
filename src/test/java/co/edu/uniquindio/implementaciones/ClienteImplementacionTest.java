package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.EditarClienteDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;
import co.edu.uniquindio.dto.TokenDTO;
import co.edu.uniquindio.servicios.implementaciones.ClienteImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ClienteImplementacionTest{
    @Autowired
    ClienteImplementacion clienteImplementacion;

    @Test
    public void registrarseTest() throws Exception {
        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "prueba01@gmail.com", "Pepito", "password", "111122224",
                "pepe", fecha, "Armenia", "0"
        );

        Assertions.assertNotNull(clienteImplementacion.registrarse(registroClienteDTO));
    }

    @Test
    public void editarPerfil() throws Exception {

        EditarClienteDTO editarClienteDTO = new EditarClienteDTO("111122224", "pepito", new TokenDTO("tokenJWT"), "", "");

        Assertions.assertNotNull(clienteImplementacion.editarPerfil(editarClienteDTO));
    }
}
