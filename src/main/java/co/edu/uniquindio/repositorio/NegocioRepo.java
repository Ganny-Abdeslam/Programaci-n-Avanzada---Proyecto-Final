package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    @Query("{}")
    List<Negocio> negicoSinEstado(String estadoNegocio);
}
