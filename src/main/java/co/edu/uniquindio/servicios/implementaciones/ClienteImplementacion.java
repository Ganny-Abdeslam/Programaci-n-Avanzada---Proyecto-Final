package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.servicios.interfaces.ClienteServicio;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SpringBootApplication
@Service
public class ClienteImplementacion implements ClienteServicio {
    private ClienteRepo clienteRepo;
    @Override
    public String registrarse(RegistroClienteDTO registroClienteDTO) throws Exception {

        if ( existeCedula(registroClienteDTO.cedula()) ){
            throw new Exception("La cedula ya se encuentra registrada");
        }

        if( existeEmail(registroClienteDTO.email()) ){
            throw new Exception("El correo ya se encuentra registrado");
        }

        if( existeNickname(registroClienteDTO.nickname()) ){
            throw new Exception("El nickname ya se encuentra registrado por otro usuario");
        }

        return iteraccionCliente(registroClienteDTO);
    }

    private boolean existeCedula( String cedula ){
        return clienteRepo.findById(cedula).isPresent();
    }

    private boolean existeNickname(String nickname) {
        return clienteRepo.findByNickname(nickname).isPresent();
    }

    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }

    private String iteraccionCliente(RegistroClienteDTO registroClienteDTO)throws Exception{
        Cliente cliente = new Cliente();

        cliente.setCedula( registroClienteDTO.cedula() );
        cliente.setNombre( registroClienteDTO.nombre() );
        cliente.setNickname( registroClienteDTO.nickname() );
        cliente.setCiudad( registroClienteDTO.ciudadResidencia() );
        cliente.setFoto( registroClienteDTO.foto() );
        cliente.setEmail( registroClienteDTO.email() );
        cliente.setPassword( registroClienteDTO.password() );
        cliente.setEstado(Estado.ACTIVO);
        Cliente clienteGuardado = clienteRepo.save(cliente);

        return clienteGuardado.getCedula();
    }
    @Override
    public String editarPerfil(RegistroClienteDTO registroClienteDTO) throws Exception {
        return iteraccionCliente(registroClienteDTO);
    }

    @Override
    public void iniciarSeccion(RegistroClienteDTO registroClienteDTO) throws Exception {

    }

    @Override
    public void eliminarCuenta(String idCuenta) throws Exception {
        if(!existeCedula(idCuenta)){
            throw new Exception("No existe la cuenta que desea eliminar");
        }

        clienteRepo.deleteById(idCuenta);
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepo.findByEmail(email).orElse(null));
    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }
}
