package co.edu.uniquindio.repositorio;


import co.edu.uniquindio.modelos.documentos.Revision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RevisionRepo extends MongoRepository<Revision, String> {

    @Query("{'estadoNegocio':?0,'codModerador.$id':?1}")
    List<Revision> estadoNegocioAndCodModerador(String estadoNegocio, String codModerador);
}
