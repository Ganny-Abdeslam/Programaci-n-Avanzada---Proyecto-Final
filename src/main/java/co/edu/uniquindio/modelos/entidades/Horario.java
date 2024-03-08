package co.edu.uniquindio.modelos.entidades;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    String dia;
    LocalTime inicio;
    LocalTime fin;
}
