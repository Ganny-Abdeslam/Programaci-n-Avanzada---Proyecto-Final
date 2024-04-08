package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.servicios.interfaces.NegocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class NegocioImplementacion implements NegocioServicio {
    @Autowired
    private NegocioRepo negocioRepo;
    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public void crearNegocio(RegistrarNegocioDTO registrarNegocioDTO) throws Exception {

        if (!existeCedula(registrarNegocioDTO.cedulaCliente())){
            throw new Exception("La cedula del cliente no se encuentra registrada");
        }

        Negocio negocio = new Negocio();

        negocio.setUbicacion(registrarNegocioDTO.ubicacion());
        negocio.setNombre(registrarNegocioDTO.nombre());
        negocio.setCodTipoNegocio(registrarNegocioDTO.codTipoNegocio());
        negocio.setEstado(Estado.ACTIVO.getNumEstado());
        negocio.setHorarios(registrarNegocioDTO.horarios());
        negocio.setDescripcion(registrarNegocioDTO.descripcion());
        negocio.setImagenes(registrarNegocioDTO.imagenes());
        negocio.setCedulaCliente(registrarNegocioDTO.cedulaCliente());

        negocioRepo.save(negocio);
    }

    private boolean existeCedula( String cedula ){
        return clienteRepo.findById(cedula).isPresent();
    }

    @Override
    public void actualizarNegocio() {

    }

    @Override
    public void buscarNegocios() {

    }

    @Override
    public void eliminarNegocio() {

    }

    @Override
    public void filtrarPorEstado() {

    }

    @Override
    public void listarNegociosPropietario() {

    }

    @Override
    public void cambiarEstado() {

    }
}
