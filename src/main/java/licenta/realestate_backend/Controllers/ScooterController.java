package licenta.realestate_backend.Controllers;


import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.DTOS.ScooterDTO;
import licenta.realestate_backend.Services.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/scooters")
public class ScooterController {
    private final ScooterService scooterService;

    @Autowired
    public ScooterController(ScooterService scooterService){
        this.scooterService=scooterService;
    }

    @GetMapping()
    public ResponseEntity<List<ScooterDTO>> getAllScooters(){
        List<ScooterDTO> list=scooterService.getAllScooters();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/marasti")
    public ResponseEntity<List<ScooterDTO>> getMarasti(){
        List<ScooterDTO> list=scooterService.getMarasti();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insert(
            @RequestParam("name") String name,
            @RequestParam("model") String model,
            @RequestParam("zone") String zone,
            @RequestParam("price") Float price,
            @RequestParam("license_plate_number") String type,
            @RequestParam("photo") MultipartFile photoFile) {
        ScooterDTO scooterDTO= new ScooterDTO();
        scooterDTO.setName(name);
        scooterDTO.setModel(model);
        scooterDTO.setZone(zone);
        scooterDTO.setPrice(price);
        try {
            scooterDTO.setPhoto(photoFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Long scooterID = scooterService.insert(scooterDTO);
        return new ResponseEntity<>(scooterID, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update" )
    public ResponseEntity<ScooterDTO> updateScooter(@RequestBody ScooterDTO scooterDTO){
        scooterService.updateScooter(scooterDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
