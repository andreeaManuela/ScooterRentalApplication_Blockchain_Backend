package licenta.realestate_backend.DTOS;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private Long id_property;

    private String name;

    private Long id_proprietar;

    private String location;

    private String address;

    private String description;

    private Float price;

    private String type;

    private String availability;

    @Lob
    private byte[] photo;

    public PropertyDTO(){

    }

    public PropertyDTO(Long id_property, String name, Long id_proprietar, String location, String address, String description, Float price, String type, String availability, byte[] photo) {
        this.id_property = id_property;
        this.name=name;
        this.id_proprietar = id_proprietar;
        this.location = location;
        this.address = address;
        this.description = description;
        this.price = price;
        this.type = type;
        this.availability = availability;
        this.photo=photo;
    }
}
