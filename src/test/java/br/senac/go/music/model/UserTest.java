
package br.senac.go.music.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.senac.go.music.relationship.onetoone.Address;
import br.senac.go.music.relationship.onetoone.User;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        Address address = Address.builder().id(1).street("street").build();
        User user = User.builder().name("nome").address(address).email("email").build();

        assertEquals("nome", user.getName());

        // Adicione mais testes para outros campos
    }

    // Adicione testes adicionais conforme necessário
}
