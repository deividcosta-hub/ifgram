package ifgram.repository;

import java.util.List;

import ifgram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
    User findByEmail(String email);
    List<User> findByNomeContainingIgnoreCase(String trecho);
}
