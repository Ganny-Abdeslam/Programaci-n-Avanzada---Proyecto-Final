package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.EditarItemDTO;
import co.edu.uniquindio.dto.EliminarItemDTO;
import co.edu.uniquindio.dto.ItemCatalogoDTO;
import co.edu.uniquindio.modelos.documentos.Catalogo;

public interface CatalogoServicio {
    void agregarItem(ItemCatalogoDTO itemCatalogoDTO) throws Exception;

    void eliminarItem(EliminarItemDTO eliminarItemDTO);

    Catalogo traerCatalgo(String codNegocio);

    void editarItem(EditarItemDTO editarItemDTO) throws Exception;
}
