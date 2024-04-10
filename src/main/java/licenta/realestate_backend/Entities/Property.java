package licenta.realestate_backend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_property", nullable = false)
    private Long id_property;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id_proprietar", nullable = false)
    private Long id_proprietar;

    @Column(name= "location", nullable = false)
    private String location;

    @Column(name= "address", nullable = false)
    private String address;

    @Column(name= "description", nullable = false)
    private String description;

    @Column(name= "price", nullable = false)
    private Float price;

    @Column(name= "type", nullable = false)
    private String type;

    @Column(name= "availability", nullable = false)
    private String availability;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public Property(String name, Long id_proprietar, String location, String address, String description, Float price, String type, String availability, byte[] photo) {
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
