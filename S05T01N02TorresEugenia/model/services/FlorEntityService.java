package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.services;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto.FlorEntityDTO;
import java.util.List;

public interface FlorEntityService {
    List<FlorEntityDTO> findAll();
    FlorEntityDTO save(FlorEntityDTO florEntityDTO);
    FlorEntityDTO update(int id,FlorEntityDTO florEntityDTO);
    String deleteById(int id);
    FlorEntityDTO findById(int id);
}