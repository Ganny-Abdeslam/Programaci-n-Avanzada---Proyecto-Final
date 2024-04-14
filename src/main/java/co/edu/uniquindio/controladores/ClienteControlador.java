package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.EditarClienteDTO;
import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;
import co.edu.uniquindio.servicios.implementaciones.ClienteImplementacion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:8082")
public class ClienteControlador {

    private final ClienteImplementacion clienteImplementacion;

    @PostMapping("/registrar-cliente")
    public ResponseEntity<MensajeDTO<String>> registrarCliente(@Valid @RequestBody RegistroClienteDTO registroClienteDTO)throws Exception{
        clienteImplementacion.registrarse(registroClienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cliente registrado correctamente"));
    }

    @PutMapping("/editar-perfil")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> actualizarCliente(@Valid @RequestBody EditarClienteDTO editarClienteDTO)throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clienteImplementacion.editarPerfil(editarClienteDTO)));
    }

    @DeleteMapping("/eliminar/{codigo}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(String codigo)throws Exception{
        clienteImplementacion.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cliente eliminado correctamente"));
    }
}
