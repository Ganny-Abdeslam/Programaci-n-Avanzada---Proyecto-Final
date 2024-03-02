package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.Estado;
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
