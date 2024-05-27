package licenta.realestate_backend.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scooter", nullable = false)
    private Long id_scooter;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "zone", nullable = false)
    private String zone;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "license_plate_number")
    private String license_plate_number;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public Scooter(String name, String model, String zone, Float price, String license_plate_number, byte[] photo) {
        this.name = name;
        this.model = model;
        this.zone = zone;
        this.price = price;
        this.license_plate_number = license_plate_number;
        this.photo = photo;
    }
}
