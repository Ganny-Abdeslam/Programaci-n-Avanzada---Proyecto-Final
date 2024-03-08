package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistroUsuarioDTO;

public interface CuentaServicio {
    void iniciarSeccion(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;

}
