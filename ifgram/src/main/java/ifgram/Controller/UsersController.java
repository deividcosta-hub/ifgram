package ifgram.Controller;

import ifgram.dto.UserResponse;
import ifgram.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    public final UserService service;

    public UsersController (UserService service){
        this.service = service;

    }

        @GetMapping
    public List<UserResponse> getUsers() {
            List<UserResponse> listaUsuarios = service.buscarTodosUsuarios();
            return listaUsuarios;
        }
        @PostMapping
        public String postUser(){
           return "chamei o endpoint como um POST" ;
        }
        @DeleteMapping
            public String deleteUser(){
            return "chamei o endpoint como um DELETE";
        }
        @PutMapping
        public String putUser(){
            return "chamei o endpoint como um PUT";
        }
        @PatchMapping
        public String patchUser(){
            return "chamei o endpoint como um PATCH";
        }
}
