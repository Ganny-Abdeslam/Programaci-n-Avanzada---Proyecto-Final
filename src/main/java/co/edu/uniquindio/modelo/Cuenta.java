package co.edu.uniquindio.modelo;

import lombok.*;

@Getter
@Setter
public class Cuenta {
    private String email;
    private String nombre;
    private String password;
    private Estado estado;
}
