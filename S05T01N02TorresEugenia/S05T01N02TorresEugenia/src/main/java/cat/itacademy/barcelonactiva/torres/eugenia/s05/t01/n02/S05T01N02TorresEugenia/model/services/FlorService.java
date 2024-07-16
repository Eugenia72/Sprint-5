package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.services;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto.FlorDto;
import java.util.*;


public interface FlorService {
    void guardar(FlorDto flordto);

    void actualizarFlor(FlorDto flordto);

    void eliminarFlor(int florID);

    FlorDto obtenerPorId(int florID);

    List<FlorDto> obtenerTodasLasFlores();
}

