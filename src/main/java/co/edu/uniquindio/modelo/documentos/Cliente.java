package co.edu.uniquindio.modelo.documentos;

import co.edu.uniquindio.modelo.entidades.Cuenta;
import co.edu.uniquindio.modelo.Estado;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document("cliente")
@Getter
@Setter
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

    @Builder
    public Cliente(String email, String nombre, String password, Estado estado, String cedula, String nickname, LocalDate fechaNacimiento, String ciudad, String foto) {
        super(email, nombre, password, estado);
        this.cedula = cedula;
        this.nickname = nickname;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.foto = foto;
    }
}