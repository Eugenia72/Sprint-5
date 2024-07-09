package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.services;


import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto.FlorEntityDTO;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.repository.FlorEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FlorEntityServiceImpl implements FlorEntityService{
    @Autowired
    FlorEntityRepository repository;

    private FlorEntityDTO toDTO(FlorEntity florEntity) {
        return new FlorEntityDTO(florEntity.getPk_FlorID(), florEntity.getNombreFlor(), florEntity.getPaisFlor(), "Tipo de Flor");
    }


    private FlorEntity toEntity(FlorEntityDTO florEntityDTO){
        FlorEntity florEntity = new FlorEntity();
        florEntity.setPk_FlorID(florEntityDTO.getPk_FlorID());
        florEntity.setNombreFlor(florEntityDTO.getNombreFlor());
        florEntity.setPaisFlor(florEntityDTO.getPaisFlor());
        return florEntity;
    }

    @Override
    public FlorEntityDTO save(FlorEntityDTO florEntityDTO){
        FlorEntity florEntity = toEntity(florEntityDTO);
        repository.save(florEntity);
        return florEntityDTO;
    }

    @Override
    public FlorEntityDTO update(int id, FlorEntityDTO florEntityDTO){
        Optional<FlorEntity> optionalFlorEntity = repository.findById(id);
        if (optionalFlorEntity.isPresent()) {
            FlorEntity florEntity = toEntity(florEntityDTO);
            florEntity.setPk_FlorID(id);
            florEntity = repository.save(florEntity);
            return toDTO(florEntity);
        } else {
            throw new RuntimeException("Flor no encontrada con identificador número: " + id);
        }
    }

    @Override
    public String deleteById(int id) {
        Optional<FlorEntity> optionalFlorEntity = repository.findById(id);
        if (optionalFlorEntity.isPresent()) {
            repository.deleteById(id);
            return "Se ha eliminado la flor correctamente";
        }else{
            throw new EntityNotFoundException("No se ha encontrado la flor a eliminar");
        }
    }

    @Override
    public FlorEntityDTO findById(int id) {
        Optional<FlorEntity> optionalFlorEntity = repository.findById(id);
        if(optionalFlorEntity.isEmpty()){
            throw new EntityNotFoundException("No se ha encontrado la flor");
        }else{
            FlorEntity florEntity =optionalFlorEntity.get();
            return toDTO(florEntity);
        }
    }

    @Override
    public List<FlorEntityDTO> findAll() {
        List<FlorEntity> florEntities = repository.findAll();
        return florEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
