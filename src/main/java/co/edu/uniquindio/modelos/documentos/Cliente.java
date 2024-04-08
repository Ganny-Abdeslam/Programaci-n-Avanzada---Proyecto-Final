package co.edu.uniquindio.modelos.documentos;

import co.edu.uniquindio.modelos.entidades.Cuenta;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document("cliente")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cliente extends Cuenta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    private String nickname;
    private LocalDate fechaNacimiento;
    private String ciudad;
    private String foto;

    @Builder
    public Cliente(String email, String nombre, String password, int estado, String cedula, String nickname, LocalDate fechaNacimiento, String ciudad, String foto) {
        super(email, nombre, password, estado);
        this.cedula = cedula;
        this.nickname = nickname;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.foto = foto;
    }

    public String getCodigo(){
        return "";
    }
}