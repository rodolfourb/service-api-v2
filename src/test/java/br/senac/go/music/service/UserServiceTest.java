
package br.senac.go.music.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.senac.go.music.repository.UserRepository;
import br.senac.go.music.relationship.onetoone.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService();
    }

    @Test
    public void testFindUserById() {
        Integer userId = 1;
        User mockUser = new User(); // Substituir com a criação de um usuário de teste
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(mockUser));

        User result = userService.findById(userId);

        assertEquals(mockUser, result);
        verify(userRepository).findById(userId);
    }

    // Outros testes unitários para cobrir os métodos restantes de UserService
}
