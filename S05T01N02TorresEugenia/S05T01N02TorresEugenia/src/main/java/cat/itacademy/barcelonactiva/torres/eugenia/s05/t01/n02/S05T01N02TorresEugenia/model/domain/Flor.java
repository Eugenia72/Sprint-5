package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int florID;
    private String nombreFlor;
    private String paisFlor;

    public Flor(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }
}
