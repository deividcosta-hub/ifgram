package ifgram.Controller;

import ifgram.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {

    public final UserService service;

    public UsersController (UserService service){
        this.service = service;

    }

        @GetMapping
        public String getUser() {
            return "Olá mundo";
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
