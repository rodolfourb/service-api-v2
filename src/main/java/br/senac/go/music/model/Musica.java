package br.senac.go.music.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data //lombok
@Builder
@Entity //jpa
@Table (name = "musica") // jpa
//@IdClass(MusicaId.class)
public class Musica {

  /*  @Id
    private int duracaoSegundos;
    @Id
    private String nome;
    */
  @EmbeddedId
  private MusicaId id;
}
