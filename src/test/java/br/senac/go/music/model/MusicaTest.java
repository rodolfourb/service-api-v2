package br.senac.go.music.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MusicaTest {

    @Test
    public void testGettersAndSetters() {
        MusicaId musicaId = MusicaId.builder().duracaoSegundos(1).nome("teste").build();
        Musica musica = Musica.builder().id(musicaId).build();

        assertEquals(1, musica.getId().getDuracaoSegundos());

        assertEquals("teste", musica.getId().getNome());

        // Adicione mais testes para outros campos
    }

    // Adicione testes adicionais conforme necessário
}
