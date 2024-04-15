package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.ImagenDTO;
import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.servicios.implementaciones.ImagenesImplementacion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
public class ImagenesControlador {
    private final ImagenesImplementacion imagenesImplementacion;

    @PostMapping("/subir")
    public ResponseEntity<MensajeDTO<Map>> subir(@RequestParam("file") MultipartFile imagen)
            throws Exception{
        Map respuesta = imagenesImplementacion.subirImagen(imagen);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, respuesta ));
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO<Map>> eliminar(@RequestBody ImagenDTO imagenDTO) throws
            Exception{
        Map respuesta = imagenesImplementacion.eliminarImagen( imagenDTO.id() );
        return ResponseEntity.ok().body(new MensajeDTO<>(false, respuesta ));
    }
}
