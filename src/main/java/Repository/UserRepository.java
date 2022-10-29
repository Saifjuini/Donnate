package Repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.nio.channels.SelectableChannel;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    @Query("Select p from User p where p.email =?1")
    Optional<User>  findByEmail(String email);


}
