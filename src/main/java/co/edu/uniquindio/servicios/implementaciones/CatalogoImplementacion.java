package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.ItemCatalogoDTO;
import co.edu.uniquindio.modelos.documentos.Catalogo;
import co.edu.uniquindio.modelos.entidades.ItemCatalogo;
import co.edu.uniquindio.repositorio.CatalogoRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.servicios.interfaces.CatalogoServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
@AllArgsConstructor
public class CatalogoImplementacion implements CatalogoServicio {
    final private CatalogoRepo catalogoRepo;
    final private NegocioRepo negocioRepo;

    @Override
    public void agregarItem(ItemCatalogoDTO itemCatalogoDTO) {
        ItemCatalogo itemCatalogo = new ItemCatalogo();

        itemCatalogo.setNombreItem(itemCatalogoDTO.nombre());
        itemCatalogo.setPrecio(itemCatalogoDTO.precio());
        itemCatalogo.setDescripcion(itemCatalogoDTO.descripcion());
        itemCatalogo.setFoto(itemCatalogoDTO.foto());

        Catalogo catalogo;
        if(catalogoRepo.findById(itemCatalogoDTO.codNegocio()).isPresent()){
            catalogo = catalogoRepo.findById(itemCatalogoDTO.codNegocio()).orElse(null);
        }else{
            catalogo = new Catalogo();
            catalogo.setCodNegocio(negocioRepo.findById(itemCatalogoDTO.codNegocio()).orElse(null));
        }

        catalogo.getItems().add(itemCatalogo);

        catalogoRepo.save(catalogo);
    }
}
