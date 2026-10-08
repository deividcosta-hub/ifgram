package ifgram.service;

import ifgram.dto.UserRequest;
import ifgram.dto.UserResponse;
import ifgram.model.User;
import ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository= repository;

    }
    @Transactional
    public UserResponse criar(UserRequest request){
        if (repository.existsByEmail(request.email())){
            throw new EmailDuplicadoException(request,email());

        }
        User salvo= repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);


    }
    public List<UserResponse> buscarUsuariosPorNome(UserRequest request) {
        List<User> listaUsuarios = repository.findAll();

    }
}
