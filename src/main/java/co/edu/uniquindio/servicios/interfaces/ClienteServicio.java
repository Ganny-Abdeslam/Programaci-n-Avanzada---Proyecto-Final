package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistroUsuarioDTO;

public interface ClienteServicio extends CuentaServicio {
    void registrarse(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;
    void editarPerfil(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;
    void eliminarCuenta(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;
    void recuperarPasswrod(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}
