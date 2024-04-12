package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.LoginDTO;
import co.edu.uniquindio.dto.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO iniciarSesionCliente(LoginDTO loginDTO) throws Exception;

    TokenDTO iniciarSesionModeradores(LoginDTO loginDTO) throws Exception;
}