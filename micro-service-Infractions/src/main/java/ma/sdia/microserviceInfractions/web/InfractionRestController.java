package ma.sdia.microserviceInfractions.web;

import ma.sdia.microserviceInfractions.entities.Infraction;
import ma.sdia.microserviceInfractions.repositories.InfractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InfractionRestController {
    @Autowired
    private InfractionRepository infractionRepository;

    @GetMapping("/infractions")
    public List<Infraction> infractions(){
        return infractionRepository.findAll();
    }

    @GetMapping("/infractions/{id}")
    public Infraction infraction(@PathVariable String id){
        return infractionRepository.findById(id).orElseThrow();
    }

    @GetMapping("/infractions/radar/{id}")
    List<Infraction> getInfractionsByRadarId(@PathVariable("id") Long id){
        return infractionRepository.findByRadarId(id);
    }

    @PostMapping("/infractions")
    public Infraction save(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @PutMapping("/infractions/{id}")
    public Infraction update(@PathVariable String id, @RequestBody Infraction infraction){
        Infraction infraction1=infractionRepository.findById(id).orElseThrow();
        if(infraction1!=null) {
            infraction.setId(id);
            return infractionRepository.save(infraction);
        }
        return null;
    }

    @DeleteMapping("/infractions/{id}")
    public void delete(@PathVariable String id){
        infractionRepository.deleteById(id);
    }

}
