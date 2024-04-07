package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CambioPasswordDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;

public interface CuentaServicio {
    void iniciarSeccion(RegistroClienteDTO registroClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;

}
