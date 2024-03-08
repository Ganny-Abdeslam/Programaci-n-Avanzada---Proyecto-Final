package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email);
}
