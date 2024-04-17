package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.EliminarItemDTO;
import co.edu.uniquindio.dto.ItemCatalogoDTO;
import co.edu.uniquindio.modelos.documentos.Catalogo;

import java.util.List;

public interface CatalogoServicio {
    void agregarItem(ItemCatalogoDTO itemCatalogoDTO);

    void eliminarItem(EliminarItemDTO eliminarItemDTO);

    Catalogo traerCatalgo(String codNegocio);
}
