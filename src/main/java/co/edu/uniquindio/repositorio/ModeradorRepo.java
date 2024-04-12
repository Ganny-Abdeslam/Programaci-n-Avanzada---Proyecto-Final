package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Moderador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends MongoRepository<Moderador, String> {
    Optional<Moderador> findByEmail(String email);
}
