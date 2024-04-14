package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.RegistrarRevisionNegocioDTO;
import co.edu.uniquindio.servicios.implementaciones.ModeradorImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ModeradorImplementacionTest {

    @Autowired
    ModeradorImplementacion moderadorImplementacion;
    @Test
    public void aceptarNegocioTest(){

        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO = new RegistrarRevisionNegocioDTO(
                "1234","661c0d040359df17bc0a9a59","",fecha);

        moderadorImplementacion.aceptarNegocio(registrarRevisionNegocioDTO);
    }

    @Test
    public void rechazarNegocioText(){
        LocalDate fecha = LocalDate.of(2000, 1, 1);

        RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO = new RegistrarRevisionNegocioDTO(
                "1234","661c0d040359df17bc0a9a59","esta es un motivo del rechazo",fecha);

        moderadorImplementacion.rechazarNegocio(registrarRevisionNegocioDTO);
    }
}
