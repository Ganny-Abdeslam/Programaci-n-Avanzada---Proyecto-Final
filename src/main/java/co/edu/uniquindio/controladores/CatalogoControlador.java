package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.EditarItemDTO;
import co.edu.uniquindio.dto.EliminarItemDTO;
import co.edu.uniquindio.dto.ItemCatalogoDTO;
import co.edu.uniquindio.dto.MensajeDTO;
import co.edu.uniquindio.modelos.documentos.Catalogo;
import co.edu.uniquindio.servicios.implementaciones.CatalogoImplementacion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogo")
@CrossOrigin(origins = "http://localhost:8082")
public class CatalogoControlador {

    private final CatalogoImplementacion catalogoImplementacion;

    @PostMapping("/agregarItem")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> agregarItem(@Valid @RequestBody ItemCatalogoDTO itemCatalogoDTO) throws Exception {
        catalogoImplementacion.agregarItem(itemCatalogoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se agrego un item al catalogo"));
    }

    @DeleteMapping("/eliminarItem")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>> eliminarItem(@Valid @RequestBody EliminarItemDTO eliminarItemDTO){
        catalogoImplementacion.eliminarItem(eliminarItemDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se elimino el item del catalogo"));
    }

    @GetMapping("/listaCatalogo/{codNegocio}")
    public ResponseEntity<MensajeDTO<Catalogo>> listaItems(String codNegocio){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, catalogoImplementacion.traerCatalgo(codNegocio)) );
    }

    @PutMapping("/editarItem")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensajeDTO<String>>editarItem(EditarItemDTO editarItemDTO) throws Exception {
        catalogoImplementacion.editarItem(editarItemDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se actualizo el item"));
    }
}
