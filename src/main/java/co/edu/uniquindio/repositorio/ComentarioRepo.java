package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends MongoRepository<Comentario, String> {
    @Query("{'codNegocio': ?0}")
    List<Comentario> listaComentariosNegocio(String codNegocio);
}
