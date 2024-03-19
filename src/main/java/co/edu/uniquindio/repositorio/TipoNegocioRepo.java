package co.edu.uniquindio.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNegocioRepo extends MongoRepository<TipoNegocioRepo, String> {
}
