package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.EditarClienteDTO;
import co.edu.uniquindio.dto.RegistroClienteDTO;
import co.edu.uniquindio.modelos.documentos.Cliente;

public interface ClienteServicio extends CuentaServicio {
    String registrarse(RegistroClienteDTO registroClienteDTO)throws Exception;
    String editarPerfil(EditarClienteDTO editarClienteDTO)throws Exception;

    Cliente verDatos(String cedula);
}
