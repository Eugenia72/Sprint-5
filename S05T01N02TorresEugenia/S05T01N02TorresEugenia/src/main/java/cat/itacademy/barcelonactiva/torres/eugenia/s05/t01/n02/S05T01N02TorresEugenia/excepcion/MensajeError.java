package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.excepcion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MensajeError {
    private int codigoEstado;
    private String mensaje;
    private String descripcionError;
}

