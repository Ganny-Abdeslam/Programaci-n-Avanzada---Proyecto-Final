package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.TipoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNegocioRepo extends MongoRepository<TipoNegocio, String> {
}
