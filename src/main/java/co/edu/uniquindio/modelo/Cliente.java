package co.edu.uniquindio.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

@Document("cliente")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Cuenta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    private String nickname;
    private LocalDate fechaNacimiento;
    private String ciudad;
    private String foto;
}