package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.dto;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain.FlorEntity;
import java.util.*;
public class FlorEntityDTO {

    private int pk_FlorID;
    private String nombreFlor;
    private String paisFlor;

    private String tipusFlor;

    private static final List<String> paises = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

    public FlorEntityDTO() {
    }

    public FlorEntityDTO(int pk_FlorID, String nombreFlor, String paisFlor, String tipusFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor = tipusFlor;
    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nomFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipusFlor() {
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }

    public static FlorEntityDTO toDTO(FlorEntity flor){
        FlorEntityDTO florEntityDTO = new FlorEntityDTO();

        florEntityDTO.setPk_FlorID(flor.getPk_FlorID());
        florEntityDTO.setNombreFlor(flor.getNombreFlor());
        florEntityDTO.setPaisFlor(flor.getPaisFlor());

        if (paises.contains(flor.getPaisFlor())){
            florEntityDTO.setTipusFlor("UE");
        } else {
            florEntityDTO.setTipusFlor("Fuera de la UE");
        }

        return florEntityDTO;
    }

    public static FlorEntity toEntity(FlorEntityDTO florDTO){
        FlorEntity florEntity = new FlorEntity();

        florEntity.setNombreFlor(florDTO.getNombreFlor());
        florEntity.setPaisFlor(florDTO.getPaisFlor());

        return florEntity;
    }
}


