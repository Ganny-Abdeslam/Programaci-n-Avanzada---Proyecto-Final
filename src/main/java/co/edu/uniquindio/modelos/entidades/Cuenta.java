package co.edu.uniquindio.modelos.entidades;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta {
    private String email;
    private String nombre;
    private String password;
    private int estado;
}
