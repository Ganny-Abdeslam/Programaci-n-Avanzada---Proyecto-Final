package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.servicios.implementaciones.NegocioImplementacion;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/negocios")
@CrossOrigin(origins = "http://localhost:8082")
public class NegocioController {
    private final NegocioImplementacion negocioImplementacion;

    @PostMapping("/crearNegocio")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody RegistrarNegocioDTO registrarNegocioDTO)throws Exception{
        negocioImplementacion.crearNegocio(registrarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Negocio creado correctamente"));
    }
}
