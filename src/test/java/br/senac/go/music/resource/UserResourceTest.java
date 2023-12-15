package br.senac.go.music.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.ArgumentMatchers.any;

import br.senac.go.music.service.UserService;
import br.senac.go.music.relationship.onetoone.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

@ExtendWith(MockitoExtension.class)
public class UserResourceTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserResource userResource;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userResource).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        // Criar um novo usuário
        User mockUser = User.builder().name("Usuario").email("email@user.com").id(1).build();
        given(userService.create(any(User.class))).willReturn(mockUser);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mockUser)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(mockUser)));
    }

    @Test
    public void testReadUser() throws Exception {
        Integer userId = 1;
        User mockUser = User.builder().name("Usuario").email("email@user.com").id(1).build();// Configure o mockUser
        given(userService.findById(userId)).willReturn(mockUser);

        mockMvc.perform(get("/users")
                .param("id", userId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(mockUser)));
    }
}
