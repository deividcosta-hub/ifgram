package ifgram.service;

import ifgram.dto.UserRequest;
import ifgram.dto.UserResponse;
import ifgram.model.User;
import ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;

    }

    @Transactional
    public UserResponse criar(UserRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new EmailDuplicadoException(request, email());

        }
        User salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);


    }

    private UserResponse from(User usarioSalvo) {
        return null;
    }

    public List<UserResponse> buscarTodosUsuarios() {
        List<User> listaUsuarios = repository.findAll();
        List<UserResponse> listaUsuariosResponse = new ArrayList<>();
        for (User user : listaUsuarios) {
            UserResponse UserResponse = new UserResponse(
                    User.getId(),
                    User.getNome(),
                    User.getEmail()
            );
            listaUsuariosResponse.add(UserResponse);
        }
        return listaUsuariosResponse;

    }

    public UserResponse atualizarUsuario(UserRequest request) throws Exception {
        Optional<User> usuario = repository.findByEmail(request.email());
        if (usuario.isEmpty()) {
            throw new Exception("usuário não existe na base de dados");
        }


        User usuarioSalvo = usuario.get();
        usuarioSalvo.setNome(request.nome());
        repository.save(usuarioSalvo);

        return UserResponse.from(usuarioSalvo);

}
        }