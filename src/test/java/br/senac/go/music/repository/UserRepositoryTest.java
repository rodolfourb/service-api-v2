
package br.senac.go.music.repository;

import static org.junit.jupiter.api.Assertions.*;

import br.senac.go.music.relationship.onetoone.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        Integer userId = 1;
        User foundUser = userRepository.findById(userId).orElse(null);

        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
    }

    // Outros testes unitários para cobrir os métodos restantes de UserRepository
}
