package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.RegistrarRevisionNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.servicios.implementaciones.ModeradorImplementacion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moderador")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeradorControlador {
    final private ModeradorImplementacion moderadorImplementacion;

    @PostMapping("/aceptarNegocio")
    @SecurityRequirement(name = "bearerAuth", scopes = {"MODERADOR"})
    public ResponseEntity<MensajeDTO<String>> aceptarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO) throws Exception {
        moderadorImplementacion.aceptarNegocio(registrarRevisionNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se acepto el negocio"));
    }

    @PostMapping("/rechazarNegocio")
    @SecurityRequirement(name = "bearerAuth", scopes = {"MODERADOR"})
    public ResponseEntity<MensajeDTO<String>> rechazarNegocio(RegistrarRevisionNegocioDTO registrarRevisionNegocioDTO) throws Exception {
        moderadorImplementacion.rechazarNegocio(registrarRevisionNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se rechazo el negocio"));
    }

    @GetMapping("/listarNegociosAceptados/{codigo}")
    @SecurityRequirement(name = "bearerAuth", scopes = {"MODERADOR"})
    public ResponseEntity<MensajeDTO<List<Negocio>>> listarNegociosAceptados(String codigo){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, moderadorImplementacion.listarNegociosAceptados(codigo)));
    }

    @GetMapping("/listarNegociosRechazados/{codigo}")
    @SecurityRequirement(name = "bearerAuth", scopes = {"MODERADOR"})
    public ResponseEntity<MensajeDTO<List<Negocio>>> listarNegociosRechazado(String codigo){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, moderadorImplementacion.listarNegociosRechazados(codigo)));
    }
}
