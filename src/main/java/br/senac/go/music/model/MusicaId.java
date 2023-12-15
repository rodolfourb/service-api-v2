package br.senac.go.music.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Embeddable
public class MusicaId implements Serializable {
    private int duracaoSegundos;
    private String nome;
}
