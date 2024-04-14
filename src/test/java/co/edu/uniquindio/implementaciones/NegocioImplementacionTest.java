package co.edu.uniquindio.implementaciones;

import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.entidades.Horario;
import co.edu.uniquindio.modelos.entidades.Ubicacion;
import co.edu.uniquindio.servicios.implementaciones.NegocioImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NegocioImplementacionTest {
    @Autowired
    NegocioImplementacion negocioImplementacion;

    @Test
    public void creaNegocioTest() throws Exception {
        List<Horario> horarios = new ArrayList<>();

        // Agregar horarios
        horarios.add(new Horario("Lunes", LocalTime.of(9, 0), LocalTime.of(12, 0)));
        horarios.add(new Horario("Martes", LocalTime.of(10, 0), LocalTime.of(13, 0)));
        horarios.add(new Horario("Miércoles", LocalTime.of(8, 30), LocalTime.of(11, 30)));
        horarios.add(new Horario("Jueves", LocalTime.of(11, 0), LocalTime.of(14, 0)));
        horarios.add(new Horario("Viernes", LocalTime.of(9, 30), LocalTime.of(12, 30)));

        RegistrarNegocioDTO registrarNegocioDTO = new RegistrarNegocioDTO(
            new Ubicacion(1.2, 2.5),
                "Negocio-Prueba",
                "Este es un negocio de prueba",
                horarios,
                "1",
                new ArrayList<>(),
                "111122224"
        );

        negocioImplementacion.crearNegocio(registrarNegocioDTO);
    }

    @Test
    public void eliminarNegocioTest(){
        negocioImplementacion.eliminarNegocio("661c0d040359df17bc0a9a59");
    }

    @Test
    public void filtarEstadoTest(){
        Assertions.assertEquals(1, negocioImplementacion.filtrarPorEstado(1).toArray().length);
    }
    @Test
    public void listarNegociosPropietarioTest(){
        Assertions.assertEquals(1,negocioImplementacion.listarNegociosPropietario("111122224").toArray().length);
    }
}
