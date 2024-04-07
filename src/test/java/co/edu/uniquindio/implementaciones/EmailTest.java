package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.EmailDTO;
import co.edu.uniquindio.servicios.interfaces.EmailServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTest {
    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void envioEmailTest() throws Exception {
        EmailDTO emailDTO = new EmailDTO("Prueba desde Test", "Esto es solo una prueba", "gabdeslamabdelgelils@uqvirtual.edu.co");

        emailServicio.enviarCorreo(emailDTO);
    }
}
