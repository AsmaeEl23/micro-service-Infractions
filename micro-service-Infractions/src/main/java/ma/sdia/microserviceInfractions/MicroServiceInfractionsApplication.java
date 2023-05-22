package ma.sdia.microserviceInfractions;

import ma.sdia.microserviceInfractions.entities.Infraction;
import ma.sdia.microserviceInfractions.repositories.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceInfractionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceInfractionsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(InfractionRepository infractionRepository){
		return args -> {

			for(int i=0;i<3;i++){
				double nb=Math.random()*100;
				Infraction infraction=Infraction.builder()
						.infraction_amount(Math.random()*1000)
						.date(new Date())
						.id(UUID.randomUUID().toString())
						.radar_max_speed(nb)
						.vehicle_license_plate(UUID.randomUUID().toString())
						.vehicle_speed(nb+Math.random()*10)
						.build();
				infractionRepository.save(infraction);
			}
		};
	}
}
