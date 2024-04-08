package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Negocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
}
