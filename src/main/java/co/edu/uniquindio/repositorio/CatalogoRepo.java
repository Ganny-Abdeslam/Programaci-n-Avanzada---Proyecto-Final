package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Catalogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogoRepo extends MongoRepository<Catalogo, String> {
}
