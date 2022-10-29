package Service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface IntUser {

    List<User> getUser();
    Optional<User> getUserByEmail(User user);
    void addNewUser(User user);
    User updateUser(User user );
    void deleteUser(Long id );
}
