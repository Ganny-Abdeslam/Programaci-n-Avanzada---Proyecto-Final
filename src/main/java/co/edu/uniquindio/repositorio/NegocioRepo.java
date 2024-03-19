package co.edu.uniquindio.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegocioRepo extends MongoRepository<NegocioRepo, String> {
}
