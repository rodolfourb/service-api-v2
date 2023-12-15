
package br.senac.go.music.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MusicaIdTest {

    @Test
    public void testGettersAndSetters() {
        MusicaId musicaId = MusicaId.builder().duracaoSegundos(1).nome("teste").build();
        assertEquals(1, musicaId.getDuracaoSegundos());
    }

    // Adicione testes adicionais conforme necessário
}
