package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.controllers;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floreseria")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<String> añadirFlor(@RequestBody FlorDto florDto) {
        florService.guardar(florDto);
        return ResponseEntity.ok("Flor añadida correctamente");
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizarFlor(@RequestBody FlorDto florDto) {
        florService.actualizarFlor(florDto);
        return ResponseEntity.ok("Datos Actualizados");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDto> obtenerUna(@PathVariable int id) {
        FlorDto florDto = florService.obtenerPorId(id);
        return ResponseEntity.ok(florDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDto>> todasLasFlores() {
        List<FlorDto> flores = (List<FlorDto>) florService.obtenerTodasLasFlores();
        return ResponseEntity.ok(flores);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarFlor(@PathVariable int id) {
        florService.eliminarFlor(id);
        return ResponseEntity.ok("Flor eliminada con exito");
    }
}