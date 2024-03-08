package co.edu.uniquindio.modelos.entidades;

import co.edu.uniquindio.modelos.enums.Estado;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Cuenta {
    private String email;
    private String nombre;
    private String password;
    private Estado estado;
}
