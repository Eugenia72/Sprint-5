package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.services;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.excepcion.FlorNoEncontradaException;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain.Flor;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.repository.FlorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService {
    @Autowired
    private FlorRepo florRepo;

    @Override
    public void guardar(FlorDto flordto) {
        Flor flor = new Flor(flordto.getNombreFlor(), flordto.getPaisFlor());
        florRepo.save(flor);
    }

    @Override
    public void actualizarFlor(FlorDto flordto) {
        Flor flor = florRepo.findById(flordto.getFlorID())
                .orElseThrow(() -> new FlorNoEncontradaException("Flor no encontrada"));
        flor.setPaisFlor(flordto.getPaisFlor());
        flor.setNombreFlor(flordto.getNombreFlor());
        florRepo.save(flor);
    }

    @Override
    public void eliminarFlor(int florID) {
        if (!florRepo.existsById(florID)) {
            throw new FlorNoEncontradaException("La flor con id: " + florID + " no existe.");
        } else {
            florRepo.deleteById(florID);
        }
    }

    @Override
    public FlorDto obtenerPorId(int florID) {
        Flor flor = florRepo.findById(florID)
                .orElseThrow(() -> new FlorNoEncontradaException("Flor no encontrada"));
        FlorDto dtoflor = new FlorDto(flor.getNombreFlor(), flor.getPaisFlor());
        dtoflor.setFlorID(florID);
        return dtoflor;
    }

    @Override
    public List<FlorDto> obtenerTodasLasFlores() {
        List<Flor> listaFlores = florRepo.findAll();
        return listaFlores.stream()
                .map(flor -> {
                    FlorDto dtoflor = new FlorDto(flor.getNombreFlor(), flor.getPaisFlor());
                    dtoflor.setFlorID(flor.getFlorID());
                    return dtoflor;
                })
                .collect(Collectors.toList());
    }
}
