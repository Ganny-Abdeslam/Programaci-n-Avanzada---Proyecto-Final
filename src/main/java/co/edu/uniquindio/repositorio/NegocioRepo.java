package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Negocio;
import co.edu.uniquindio.modelos.enums.EstadoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    List<Negocio> findByEstado(int estado);

    List<Negocio> findByCodTipoNegocio(String codTipoNegocio);

    List<Negocio> findByCedulaCliente(String cedula);
}
