package licenta.realestate_backend.Services;

import jakarta.persistence.EntityNotFoundException;
import licenta.realestate_backend.DTOS.Builders.PropertyBuilder;
import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.Entities.Property;
import licenta.realestate_backend.Repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository){
        this.propertyRepository=propertyRepository;
    }

    //GET ALL PROPERTIES
    public List<PropertyDTO> getAllProperties(){
        List<Property> propertyList= propertyRepository.findAll();
        return propertyList.stream()
                .map(PropertyBuilder::toPropertyDTO)
                .collect(Collectors.toList());
    }

    //PROPERTIES RENT
    public List<PropertyDTO> getRentProperties(){
        List<Property> propertyList= propertyRepository.getRentProperties();
        return propertyList.stream()
                .map(PropertyBuilder::toPropertyDTO)
                .collect(Collectors.toList());
    }

    //PROPERTIES SALE
    public List<PropertyDTO> getSaleProperties(){
        List<Property> propertyList= propertyRepository.getPropertiesBySale();
        return propertyList.stream()
                .map(PropertyBuilder::toPropertyDTO)
                .collect(Collectors.toList());
    }

    //INSERT
    public Long insert(PropertyDTO propertyDTO){
        propertyDTO.setId_proprietar(1L);
        Property property= PropertyBuilder.toEntity(propertyDTO);
        property=propertyRepository.save(property);
        System.out.println("Property with id " + property.getId_property() + " was inserted in db " );
        return property.getId_property();

    }

    //UPDATE
    public void updateProperty(PropertyDTO propertyDTO){
        Optional<Property> optionalProperty = propertyRepository.updateProperty(propertyDTO.getName());
        //verific daca exista utilizatorul in baza de date
        if(!optionalProperty.isPresent()){
            throw new EntityNotFoundException("Property with name: " + propertyDTO.getName() + " not found!");
        }
        Property property = optionalProperty.get();
        if(StringUtils.hasText(propertyDTO.getDescription())){
            property.setDescription(propertyDTO.getDescription());
        }
        if(StringUtils.hasText(propertyDTO.getType())){
            property.setType(propertyDTO.getType());
        }
        if(StringUtils.hasText(propertyDTO.getAvailability())){
            property.setAvailability(propertyDTO.getAvailability());
        }
        if(propertyDTO.getPrice() != null){
            property.setPrice(propertyDTO.getPrice());
        }
        //salvez userul si il actualizez in baza de date
        Property update= propertyRepository.save(property);
    }


    //DELETE
    public void delete(Long id){
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if(!optionalProperty.isPresent()){
            throw new EntityNotFoundException("Property with ID:" + id + " not found!");
        }
        propertyRepository.deleteById(id);

    }


}
