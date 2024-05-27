package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.ScooterDTO;
import licenta.realestate_backend.Entities.Scooter;

public class ScooterBuilder {

    private ScooterBuilder(){

    }

    public static ScooterDTO toScooterDTO(Scooter scooter){
        return new ScooterDTO(
                scooter.getId_scooter(),
                scooter.getName(),
                scooter.getModel(),
                scooter.getZone(),
                scooter.getPrice(),
                scooter.getLicense_plate_number(),
                scooter.getPhoto()
        );
    }

    public static Scooter toEntity(ScooterDTO scooterDTO){
        return new Scooter(
                scooterDTO.getId_scooter(),
                scooterDTO.getName(),
                scooterDTO.getModel(),
                scooterDTO.getZone(),
                scooterDTO.getPrice(),
                scooterDTO.getLicense_plate_number(),
                scooterDTO.getPhoto()
        );
    }
}
