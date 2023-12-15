
package br.senac.go.music.repository;


import static org.junit.jupiter.api.Assertions.*;

import br.senac.go.music.relationship.onetoone.User;
import br.senac.go.music.relationship.onetoone.User.UserBuilder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindById() {
        // Criar um novo usuário
        User newUser = User.builder().name("Usuario").email("email@user.com").id(1).build();
        // Configurar newUser com os dados necessários

        // Persistir o novo usuário
        newUser = entityManager.merge(newUser);
        entityManager.flush();

        // Buscar o usuário
        User foundUser = userRepository.findById(newUser.getId()).orElse(null);

        assertNotNull(foundUser);
        assertEquals(newUser.getId(), foundUser.getId());
    }
}