package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FlorDto implements Serializable {
    @Setter
    private int florID;
    private String nombreFlor;
    private String paisFlor;
    private String tipoRama;

    private static final List<String> paisesEuropeos = new ArrayList<>(Arrays.asList("irlanda","belgica","francia",
            "italia","austria","alemania","grecia", "españa", "bulgaria", "croacia", "republica de chipre",
            "paises bajos","luxemburgo", "malta", "polonia", "rumania", "eslovaquia", "eslovenia", "suecia",
            "finlandia","republica checa", "dinamarca", "letonia", "lituania" ));

    public FlorDto(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        this.tipoRama = paisFlor != null && paisesEuropeos.contains(paisFlor.toLowerCase()) ? "UE" : "NO UE";
    }
}
