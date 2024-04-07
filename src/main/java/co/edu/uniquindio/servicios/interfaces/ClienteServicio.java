package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.RegistroClienteDTO;

public interface ClienteServicio extends CuentaServicio {
    String registrarse(RegistroClienteDTO registroClienteDTO)throws Exception;
    String editarPerfil(RegistroClienteDTO registroClienteDTO)throws Exception;
}
