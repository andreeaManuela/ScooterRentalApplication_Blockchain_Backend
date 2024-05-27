package licenta.realestate_backend.DTOS;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScooterDTO {
    private Long id_scooter;

    private String name;

    private String model;

    private String zone;

    private Float price;;

    private String license_plate_number;

    @Lob
    private byte[] photo;




}
