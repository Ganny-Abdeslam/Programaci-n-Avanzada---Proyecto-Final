package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.entidades.Cuenta;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("moderador")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Moderador extends Cuenta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String email, String nombre, String password, int estado, String codigo) {
        super(email, nombre, password, estado);
        this.codigo = codigo;
    }
}
