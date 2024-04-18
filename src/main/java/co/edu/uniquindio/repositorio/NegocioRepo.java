package co.edu.uniquindio.repositorio;

import co.edu.uniquindio.modelos.documentos.Negocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    List<Negocio> findByEstado(int estado);

    List<Negocio> findByCodTipoNegocio(String tipoNegocioId);

    List<Negocio> findByCedulaCliente(String cedula);

    List<Negocio> findByNombreRegex(String nombreRegex);
}
