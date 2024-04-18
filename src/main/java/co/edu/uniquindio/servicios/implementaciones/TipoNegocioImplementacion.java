package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.TipoNegocioDTO;
import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import co.edu.uniquindio.repositorio.TipoNegocioRepo;
import co.edu.uniquindio.servicios.interfaces.TipoNegocioServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SpringBootApplication
@AllArgsConstructor
public class TipoNegocioImplementacion implements TipoNegocioServicio {

    final private TipoNegocioRepo tipoNegocioRepo;

    @Override
    public List<TipoNegocio> traerTipoNegocios() {
        return tipoNegocioRepo.findAll();
    }

    @Override
    public void agregarTipo(TipoNegocioDTO tipoNegocioDTO) {
        TipoNegocio tipoNegocio = new TipoNegocio();

        tipoNegocio.setCodigo(String.valueOf(tipoNegocioRepo.count()+1));
        tipoNegocio.setNombre(tipoNegocioDTO.nombre());
        tipoNegocio.setRestriccion(tipoNegocioDTO.restriccion());

        tipoNegocioRepo.save( tipoNegocio );
    }

}
