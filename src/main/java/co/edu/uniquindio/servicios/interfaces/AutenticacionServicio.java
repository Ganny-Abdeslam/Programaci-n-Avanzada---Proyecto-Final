package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.LoginDTO;
import co.edu.uniquindio.dto.TokenDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;

public interface AutenticacionServicio {
    TokenDTO iniciarSesionCliente(LoginDTO loginDTO) throws Exception;

    TokenDTO iniciarSesionModeradores(LoginDTO loginDTO) throws Exception;

    TokenDTO cambioPassword(Cliente cliente) throws Exception;
}