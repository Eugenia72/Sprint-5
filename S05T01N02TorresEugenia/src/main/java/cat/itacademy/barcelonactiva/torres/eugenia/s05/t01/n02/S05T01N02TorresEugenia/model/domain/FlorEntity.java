package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "Flores")
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_FlorID")
    private int pk_FlorID;

    @Column(name = "NOMBRE")
    private String nombreFlor;

    @Column(name = "PAIS")
    private String paisFlor;

    // Constructor con todos los argumentos
    public FlorEntity(int pk_FlorID, String nombreFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    // Constructor sin pk_FlorID
    public FlorEntity(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    // Constructor vacío requerido por JPA
    public FlorEntity() {
    }

    // Getters y setters
    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
