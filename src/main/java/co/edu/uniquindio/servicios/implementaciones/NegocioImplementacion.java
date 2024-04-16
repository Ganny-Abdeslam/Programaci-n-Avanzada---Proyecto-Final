package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.ActualizarNegocioDTO;
import co.edu.uniquindio.dto.CambioEstadoDTO;
import co.edu.uniquindio.dto.RegistrarNegocioDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.repositorio.NegocioRepo;
import co.edu.uniquindio.servicios.interfaces.NegocioServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
@AllArgsConstructor
public class NegocioImplementacion implements NegocioServicio {

    final private NegocioRepo negocioRepo;
    final private ClienteRepo clienteRepo;

    @Override
    public void crearNegocio(RegistrarNegocioDTO registrarNegocioDTO) throws Exception {

        if (!existeCedula(registrarNegocioDTO.cedulaCliente())){
            throw new Exception("La cedula del cliente no se encuentra registrada");
        }

        Negocio negocio = new Negocio();

        Cliente cliente = new Cliente();
        TipoNegocio tipoNegocio = new TipoNegocio();

        cliente.setCedula(registrarNegocioDTO.cedulaCliente());
        tipoNegocio.setCodigo(registrarNegocioDTO.codTipoNegocio());

        negocio.setUbicacion(registrarNegocioDTO.ubicacion());
        negocio.setNombre(registrarNegocioDTO.nombre());
        negocio.setCodTipoNegocio(tipoNegocio);
        negocio.setEstado(Estado.SOLICITADO.getNumEstado());
        negocio.setHorarios(registrarNegocioDTO.horarios());
        negocio.setDescripcion(registrarNegocioDTO.descripcion());
        negocio.setImagenes(registrarNegocioDTO.imagenes());
        negocio.setCedulaCliente(cliente);

        negocioRepo.save(negocio);
    }

    private boolean existeCedula( String cedula ){
        return clienteRepo.findById(cedula).isPresent();
    }

    private boolean existeNegocio( String codigo ){
        return negocioRepo.findById(codigo).isPresent();
    }

    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {

        Negocio negocio = negocioRepo.findById(actualizarNegocioDTO.codigo()).orElse(null);

        if (!existeCedula(actualizarNegocioDTO.cedulaCliente())){
            throw new Exception("La cedula del cliente no se encuentra registrada");
        }

        if (!existeNegocio(actualizarNegocioDTO.codigo())){
            throw new Exception("El negocio no existe no se encuentra registrada");
        }

        TipoNegocio tipoNegocio = new TipoNegocio();
        tipoNegocio.setCodigo(actualizarNegocioDTO.codTipoNegocio());

        negocio.setUbicacion(actualizarNegocioDTO.ubicacion());
        negocio.setNombre(actualizarNegocioDTO.nombre());
        negocio.setCodTipoNegocio(tipoNegocio);
        negocio.setEstado(Estado.SOLICITADO.getNumEstado());
        negocio.setHorarios(actualizarNegocioDTO.horarios());
        negocio.setDescripcion(actualizarNegocioDTO.descripcion());
        negocio.setImagenes(actualizarNegocioDTO.imagenes());

        negocioRepo.save(negocio);
    }

    @Override
    public void buscarNegocios() {

    }

    @Override
    public void eliminarNegocio(String codNegocio) {
        Negocio negocio = negocioRepo.findById(codNegocio).orElse(null);
        assert negocio != null;
        negocio.setEstado(Estado.INACTIVO.getNumEstado());
        negocioRepo.save(negocio);
    }

    @Override
    public List<Negocio> filtrarPorEstado(int estado) {
        return negocioRepo.findByEstado(estado);
    }

    @Override
    public List<Negocio> listarNegociosPropietario(String cedula) {
        return negocioRepo.findByCedulaCliente(cedula);
    }

    @Override
    public void cambiarEstado(CambioEstadoDTO cambioEstadoDTO) {
        Negocio negocio = negocioRepo.findById(cambioEstadoDTO.id()).orElse(null);

        assert negocio != null;
        negocio.setEstado(cambioEstadoDTO.estado().getNumEstado());

        negocioRepo.save( negocio );
    }
}
