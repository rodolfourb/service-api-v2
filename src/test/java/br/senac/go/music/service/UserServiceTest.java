
package br.senac.go.music.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.senac.go.music.repository.UserRepository;
import br.senac.go.music.relationship.onetoone.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

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