package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Catalogo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CatalogoRepo extends MongoRepository<Catalogo, String> {
    Optional<Catalogo> findByCodNegocio(String codNegocio);
}
