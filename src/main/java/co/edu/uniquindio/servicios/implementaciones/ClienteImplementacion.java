package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.modelos.documentos.Cliente;
import co.edu.uniquindio.modelos.enums.Estado;
import co.edu.uniquindio.repositorio.ClienteRepo;
import co.edu.uniquindio.servicios.interfaces.ClienteServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SpringBootApplication
@Service
@RequiredArgsConstructor
public class ClienteImplementacion implements ClienteServicio {

    final private ClienteRepo clienteRepo;
    final private EmailImplementacion emailImplementacion;
    final private AutenticacionImplementacion autenticacionImplementacion;

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

        Cliente cliente = interaccionCliente(registroClienteDTO);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( registroClienteDTO.password() );
        cliente.setPassword( passwordEncriptada );

        clienteRepo.save(cliente);

        return cliente.getCedula();
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

    private Cliente interaccionCliente(RegistroClienteDTO registroClienteDTO)throws Exception{
        Cliente cliente = new Cliente();

        cliente.setCedula( registroClienteDTO.cedula() );
        cliente.setNombre( registroClienteDTO.nombre() );
        cliente.setNickname( registroClienteDTO.nickname() );
        cliente.setCiudad( registroClienteDTO.ciudad() );
        cliente.setFechaNacimiento( registroClienteDTO.fechaNacimiento() );
        cliente.setFoto( registroClienteDTO.foto() );
        cliente.setEmail( registroClienteDTO.email() );
        cliente.setEstado(Estado.ACTIVO.getNumEstado());

        return clienteRepo.save(cliente);
    }
    @Override
    public String editarPerfil(EditarClienteDTO editarClienteDTO) throws Exception {

        Cliente cliente = clienteRepo.findById(editarClienteDTO.cedula()).orElse(null);

        cliente.setNombre(editarClienteDTO.nombre() != null ? editarClienteDTO.nombre() : cliente.getNombre());
        cliente.setFoto(editarClienteDTO.foto() != null ? editarClienteDTO.foto() : cliente.getFoto());
        cliente.setCiudad(editarClienteDTO.ciudad() != null ? editarClienteDTO.ciudad() : cliente.getCiudad());

        clienteRepo.save(cliente);
        return "Se actualizo el cliente exitosamente";
    }

    @Override
    public Cliente verDatos(String cedula) {
        return clienteRepo.findById(cedula).orElse(null);
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

        if(!existeEmail(email)){
            throw new Exception("El correo no se encuentra registrado");
        }

        TokenDTO tokenDTO = autenticacionImplementacion.cambioPassword(cliente.get());

        String url = "URL/"+tokenDTO.token();

        emailImplementacion.enviarCorreo(new EmailDTO("Recuperación contraseña UniLocal",
                "Ingrese al siguiente link para su cambio de contraseña: "+url, email));
    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {
        Cliente cliente = clienteRepo.findById(cambioPasswordDTO.codCliente()).orElse(null);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if( !passwordEncoder.matches(cambioPasswordDTO.password(), cliente.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }

        if( !cambioPasswordDTO.passwordNew().equals(cambioPasswordDTO.passwordConfr()) ){
            throw new Exception("Las contraseñas no son iguales");
        }

        String passwordEncriptada = passwordEncoder.encode( cambioPasswordDTO.password() );
        cliente.setPassword( passwordEncriptada );

        clienteRepo.save( cliente );
    }
}
