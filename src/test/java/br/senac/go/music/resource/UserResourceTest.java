
package br.senac.go.music.resource;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import br.senac.go.music.service.UserService;
import br.senac.go.music.relationship.onetoone.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

public class UserResourceTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(new UserResource()).build();
    }

    @Test
    public void testGetUserById() throws Exception {
        Integer userId = 1;
        User mockUser = new User(); // Substituir com a criação de um usuário de teste
        when(userService.findById(userId)).thenReturn(mockUser);

        mockMvc.perform(get("/user/" + userId))
               .andExpect(status().isOk())
               .andExpect(content().json(new ObjectMapper().writeValueAsString(mockUser)));
    }

    // Outros testes unitários para cobrir os métodos restantes de UserResource
}
