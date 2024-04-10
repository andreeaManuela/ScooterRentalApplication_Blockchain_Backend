package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.Repositories.PropertyRepository;
import licenta.realestate_backend.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/property")
public class PropertyController {

    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyController(PropertyService propertyService,
                              PropertyRepository propertyRepository){
        this.propertyService=propertyService;
        this.propertyRepository = propertyRepository;
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
    public ResponseEntity<Long> insert(@RequestBody PropertyDTO propertyDTO) {
        Long propertID = propertyService.insert(propertyDTO);
        return new ResponseEntity<>(propertID, HttpStatus.CREATED);
    }


    @PatchMapping(value = "/update" )
    public ResponseEntity<PropertyDTO> updateUser(@RequestBody PropertyDTO propertyDTO){
        propertyService.updateProperty(propertyDTO);
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
