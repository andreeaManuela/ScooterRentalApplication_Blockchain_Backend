package licenta.realestate_backend.Services;

import jakarta.persistence.EntityNotFoundException;
import licenta.realestate_backend.DTOS.Builders.ScooterBuilder;
import licenta.realestate_backend.DTOS.ScooterDTO;
import licenta.realestate_backend.Entities.Scooter;
import licenta.realestate_backend.Repositories.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScooterService {

    private final ScooterRepository scooterRepository;

    @Autowired
    public ScooterService(ScooterRepository scooterRepository){
        this.scooterRepository=scooterRepository;
    }

    //GET ALL SCOOTERS
    public List<ScooterDTO> getAllScooters(){
        List<Scooter> scooterList= scooterRepository.findAll();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }
    //SCOOTERS MARASTI
    public List<ScooterDTO> getMarasti(){
        List<Scooter> scooterList= scooterRepository.getScootersMarasti();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }

    //SCOOTERS MANASTUR
    public List<ScooterDTO> getManastur(){
        List<Scooter> scooterList= scooterRepository.getScootersManastur();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }

    //SCOOTERS ZORILOR
    public List<ScooterDTO> getZorilor(){
        List<Scooter> scooterList= scooterRepository.getScootersZorilor();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }

    //SCOOTERS GHEORGHENI
    public List<ScooterDTO> getGheorgheni(){
        List<Scooter> scooterList= scooterRepository.getScootersGheorgheni();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }

    //SCOOTERS CENTRU
    public List<ScooterDTO> getCentru(){
        List<Scooter> scooterList= scooterRepository.getScootersCentru();
        return scooterList.stream()
                .map(ScooterBuilder::toScooterDTO)
                .collect(Collectors.toList());
    }

    //INSERT
    public Long insert(ScooterDTO scooterDTO){
        Scooter scooter = ScooterBuilder.toEntity(scooterDTO);
        scooter= scooterRepository.save(scooter);
        System.out.println("Scooter with id " + scooter.getId_scooter() + " was inserted in db " );
        return scooter.getId_scooter();

    }

    //UPDATE
    public void updateScooter(ScooterDTO scooterDTO){
        Optional<Scooter> optionalScooter = scooterRepository.updateScooter(scooterDTO.getName());
        //verific daca exista scooterul in baza de date in baza de date
        if(!optionalScooter.isPresent()){
            throw new EntityNotFoundException("Scooter with name: " + scooterDTO.getName() + " not found!");
        }
        Scooter scooter= optionalScooter.get();
        if(StringUtils.hasText(scooterDTO.getZone())){
            scooter.setZone(scooterDTO.getZone());
        }

        if(scooterDTO.getPrice() != null){
            scooter.setPrice(scooterDTO.getPrice());
        }
        //salvez scooterul si il actualizez in baza de date
        Scooter update= scooterRepository.save(scooter);
    }

}
