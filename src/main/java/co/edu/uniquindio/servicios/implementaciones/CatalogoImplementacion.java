package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.EditarItemDTO;
import co.edu.uniquindio.dto.EliminarItemDTO;
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
    public void agregarItem(ItemCatalogoDTO itemCatalogoDTO) throws Exception {
        ItemCatalogo itemCatalogo = new ItemCatalogo();

        itemCatalogo.setNombreItem(itemCatalogoDTO.nombre());
        itemCatalogo.setPrecio(itemCatalogoDTO.precio());
        itemCatalogo.setDescripcion(itemCatalogoDTO.descripcion());
        itemCatalogo.setFoto(itemCatalogoDTO.foto());

        Catalogo catalogo = catalogoRepo.findByCodNegocio(itemCatalogoDTO.codNegocio()).orElse(null);;
        if(catalogo == null){
            catalogo = new Catalogo();
            catalogo.setCodNegocio(negocioRepo.findById(itemCatalogoDTO.codNegocio()).orElse(null));
        }

        for (ItemCatalogo i: catalogo.getItems()){
            if(i.getNombreItem().equals(itemCatalogoDTO.nombre())){
                throw new Exception("Este nombre ya lo posee un item del Catalogo actual");
            }
        }

        catalogo.getItems().add(itemCatalogo);

        catalogoRepo.save(catalogo);
    }

    @Override
    public void eliminarItem(EliminarItemDTO eliminarItemDTO) {
        Catalogo catalogo = catalogoRepo.findById(eliminarItemDTO.codCatalogo()).orElse(null);

        assert catalogo != null;
        catalogo.getItems().removeIf(i -> i.getNombreItem().equals(eliminarItemDTO.nombre()));

        catalogoRepo.save( catalogo );
    }

    @Override
    public Catalogo traerCatalgo(String codNegocio) {
        return catalogoRepo.findByCodNegocio(codNegocio).orElse(null);
    }

    @Override
    public void editarItem(EditarItemDTO editarItemDTO) throws Exception {
        Catalogo catalogo = catalogoRepo.findById(editarItemDTO.codCatalogo()).orElse(null);

        assert catalogo != null;
        for (ItemCatalogo i: catalogo.getItems()){
            if(i.getNombreItem().equals(editarItemDTO.nombre())){
                i.setPrecio(editarItemDTO.precio());
                i.setDescripcion(editarItemDTO.descripcion());
                i.setFoto(editarItemDTO.foto());

                catalogo.getItems().set(catalogo.getItems().indexOf(i), i);
                catalogoRepo.save( catalogo );
                return;
            }
        }

        throw new Exception("No existe el producto que desea editar");
    }
}
