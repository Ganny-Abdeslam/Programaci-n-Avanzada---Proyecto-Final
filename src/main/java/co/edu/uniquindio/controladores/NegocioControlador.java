package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.FiltroNombreDTO;
import co.edu.uniquindio.dto.FiltroTipoDTO;
import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.servicios.implementaciones.NegocioImplementacion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/negocios")
@CrossOrigin(origins = "http://localhost:4200")
public class NegocioControlador {
    private final NegocioImplementacion negocioImplementacion;

    @PostMapping("/crearNegocio")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody RegistrarNegocioDTO registrarNegocioDTO)throws Exception{
        negocioImplementacion.crearNegocio(registrarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Negocio creado correctamente"));
    }

    @GetMapping("/filtroEstado/{estado}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<List<Negocio>>> filtrarPorEstado(int estado){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.filtrarPorEstado(estado)));
    }

    @GetMapping("/filtroTipo")
    public ResponseEntity<MensajeDTO<List<Negocio>>> filtrarPorTipo(@Valid @RequestBody FiltroTipoDTO filtroTipoDTO){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.negociosTipo(filtroTipoDTO)));
    }

    @GetMapping("/filtroNombre")
    public ResponseEntity<MensajeDTO<List<Negocio>>> filtrarPorNombre(@Valid @RequestBody FiltroNombreDTO filtroNombreDTO){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.negocioNombre(filtroNombreDTO)));
    }

    @GetMapping("/todoLosNegocios/{cedula}")
    public ResponseEntity<MensajeDTO<List<Negocio>>> filtrarPorNombre(String cedula){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.listarNegocios(cedula)));
    }

    @GetMapping("/listarNegociosPropiedad/{cedula}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<List<Negocio>>> listarNegociosPropiedad(String cedula){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.listarNegociosPropietario(cedula)));
    }

    @DeleteMapping("/eliminarNegocio/{codigo}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> eliminarNegocio(String codigo){
        negocioImplementacion.eliminarNegocio(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El negocio se a eliminado"));
    }

    @GetMapping("/traerNegocio/{codNegocio}")
    public ResponseEntity<MensajeDTO<Negocio>> traerNegocio(String codNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, negocioImplementacion.traerNegocio(codNegocio)));
    }
}
