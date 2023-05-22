package ma.sdia.microserviceInfractions.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class Infraction {
    @Id
    private String id;
    private Date date;
    private Long radarId;
    private String vehicle_license_plate;
    private double vehicle_speed;
    private double radar_max_speed;
    private double infraction_amount;
}
