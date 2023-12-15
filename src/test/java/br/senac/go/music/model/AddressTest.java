package br.senac.go.music.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.senac.go.music.relationship.onetoone.Address;

public class AddressTest {

    @Test
    public void testGettersAndSetters() {
        Address address = Address.builder().id(1).street("street").build();

        assertEquals(1, address.getId());

        assertEquals("street", address.getStreet());

        // Adicione mais testes para outros campos
    }

    // Adicione testes adicionais conforme necessário
}
