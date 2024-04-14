package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.documentos.Revision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepo extends MongoRepository<Revision, String> {

    @Query("{ 'estado': '1' }")
    List<Revision> revisionAprovada();

    @Query("{ 'estado': '3' }")
    List<Revision> revisionRechazada();
}
