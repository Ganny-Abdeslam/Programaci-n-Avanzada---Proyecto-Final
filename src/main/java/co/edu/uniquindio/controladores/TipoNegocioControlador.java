package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.TipoNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import co.edu.uniquindio.servicios.implementaciones.TipoNegocioImplementacion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tipo")
@CrossOrigin(origins = "http://localhost:8082")
@SecurityRequirement(name = "bearerAuth", scopes = {"MODERADOR"})
public class TipoNegocioControlador {
    private final TipoNegocioImplementacion tipoNegocioImplementacion;

    @GetMapping("/tipoNegocios")
    public ResponseEntity<MensajeDTO<List<TipoNegocio>>> traerTipos(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, tipoNegocioImplementacion.traerTipoNegocios()));
    }

    @PostMapping("/agregarTipo")
    public ResponseEntity<MensajeDTO<String>> agregarTipo(TipoNegocioDTO tipoNegocioDTO){
        tipoNegocioImplementacion.agregarTipo(tipoNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se agregp el tipo"));
    }
}
