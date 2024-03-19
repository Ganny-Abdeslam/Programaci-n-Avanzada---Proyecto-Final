package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Revision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepo extends MongoRepository<Revision, String> {
}
