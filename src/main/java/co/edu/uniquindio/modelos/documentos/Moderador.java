package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.entidades.Cuenta;
import co.edu.uniquindio.modelos.enums.Estado;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("moderador")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderador extends Cuenta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String email, String nombre, String password, Estado estado, String codigo) {
        super(email, nombre, password, estado);
        this.codigo = codigo;
    }
}
