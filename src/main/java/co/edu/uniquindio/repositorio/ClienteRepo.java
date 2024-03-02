package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelo.documentos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    
}
