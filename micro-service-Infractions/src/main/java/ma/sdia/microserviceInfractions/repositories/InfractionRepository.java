package ma.sdia.microserviceInfractions.repositories;


import ma.sdia.microserviceInfractions.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RestResource
@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction,String> {
    @RestResource(path="/infractions/radar/{id}")
    List<Infraction> findByRadarId(@Param("id") Long id);
}
