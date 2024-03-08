package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.servicios.interfaces.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ClienteImplementacion implements ClienteServicio {
    @Autowired
    private ClienteRepo clienteRepo;
    @Override
    public void registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {

    }

    @Override
    public void editarPerfil(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {

    }

    @Override
    public void eliminarCuenta(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {

    }

    @Override
    public void iniciarSeccion(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {

    }

    @Override
    public void eliminarCuenta(String idCuenta) throws Exception {

    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepo.findByEmail(email).orElse(null));
    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }

    @Override
    public void recuperarPasswrod(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }
}
