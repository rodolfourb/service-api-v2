package br.senac.go.music.resource;

import br.senac.go.music.relationship.onetoone.User;
import br.senac.go.music.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(@Valid @RequestBody User user){
        log.info("Acessando a camada de serviço");
        return this.userService.create(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User read(@PathParam("id") Integer id){
        log.info("Acessando a camada de serviço");
        return this.userService.findById(id);
    }
}
