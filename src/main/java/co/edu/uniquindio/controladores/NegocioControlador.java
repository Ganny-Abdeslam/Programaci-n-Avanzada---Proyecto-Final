package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.servicios.implementaciones.NegocioImplementacion;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/negocios")
@CrossOrigin(origins = "http://localhost:8082")
public class NegocioControlador {
    private final NegocioImplementacion negocioImplementacion;

    @PostMapping("/crearNegocio")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody RegistrarNegocioDTO registrarNegocioDTO)throws Exception{
        negocioImplementacion.crearNegocio(registrarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Negocio creado correctamente"));
    }

    @GetMapping("/filtroEstado/{estado}")
    public ResponseEntity<MensajeDTO<List<Negocio>>> filtrarPorEstado(int estado){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.filtrarPorEstado(estado)));
    }

    @GetMapping("/listarNegociosPropiedad/{cedula}")
    public ResponseEntity<MensajeDTO<List<Negocio>>> listarNegociosPropiedad(String cedula){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.listarNegociosPropietario(cedula)));
    }

    @DeleteMapping("/eliminarNegocio/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarNegocio(String codigo){
        negocioImplementacion.eliminarNegocio(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El negocio se a eliminado"));
    }
}
