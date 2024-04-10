package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.Entities.Property;

public class PropertyBuilder {

    private PropertyBuilder(){

    }

    public static PropertyDTO toPropertyDTO(Property property){
        return new PropertyDTO(
          property.getId_property(),
          property.getName(),
          property.getId_proprietar(),
          property.getLocation(),
          property.getAddress(),
          property.getDescription(),
          property.getPrice(),
          property.getType(),
          property.getAvailability(),
          property.getPhoto()
        );
    }

    public static Property toEntity(PropertyDTO property){
        return new Property(
                property.getId_property(),
                property.getName(),
                property.getId_proprietar(),
                property.getLocation(),
                property.getAddress(),
                property.getDescription(),
                property.getPrice(),
                property.getType(),
                property.getAvailability(),
                property.getPhoto()
        );
    }
}
