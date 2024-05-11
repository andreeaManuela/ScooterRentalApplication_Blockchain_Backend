package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.Repositories.PropertyRepository;
import licenta.realestate_backend.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/property")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService){
        this.propertyService=propertyService;
    }

    @GetMapping()
    public ResponseEntity<List<PropertyDTO>> getProperties(){
        List<PropertyDTO> list=propertyService.getAllProperties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/rent")
    public ResponseEntity<List<PropertyDTO>> getRentProperties(){
        List<PropertyDTO> list=propertyService.getRentProperties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/sale")
    public ResponseEntity<List<PropertyDTO>> getSaleProperties(){
        List<PropertyDTO> list=propertyService.getSaleProperties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insert(
            @RequestParam("name") String name,
            @RequestParam("location") String location,
            @RequestParam("address") String address,
            @RequestParam("description") String description,
            @RequestParam("price") Float price,
            @RequestParam("type") String type,
            @RequestParam("availability") String availability,
            @RequestParam("photo") MultipartFile photoFile) {
       PropertyDTO propertyDTO = new PropertyDTO();
       propertyDTO.setName(name);
       propertyDTO.setLocation(location);
       propertyDTO.setAddress(address);
       propertyDTO.setDescription(description);
       propertyDTO.setPrice(price);
       propertyDTO.setType(type);
       propertyDTO.setAvailability(availability);
        try {
            propertyDTO.setPhoto(photoFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Long propertID = propertyService.insert(propertyDTO);
        return new ResponseEntity<>(propertID, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/updateOwner" )
    public ResponseEntity<PropertyDTO> updateOwner(@RequestBody Map<String, Long> param){//(@RequestParam("id_property") Long id_property, @RequestParam("id_new_owner") Long id_new_owner){
        Long id_property= param.get("id_property");
        Long id_new_owner = param.get("id_new_owner");

        propertyService.updatePropertyOwner(id_property, id_new_owner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping(value = "/update" )
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO){
        propertyService.updateProperty(propertyDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping(value = "/update/availability/{id_property}" )
    public ResponseEntity<PropertyDTO> updatePropertyAvailability(@PathVariable("id_property") Long id_property){
        propertyService.updatePropertyAvailability(id_property);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id_property}")
    public ResponseEntity<PropertyDTO> deleteUser(@PathVariable("id_property") Long id_property){
        try {
            propertyService.delete(id_property);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
