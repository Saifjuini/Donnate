package Service;

import Repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements  IntUser{
    @Autowired
    private UserRepository userrepo ;

    public List<User> getUser(){
        return userrepo.findAll();
    }
    public Optional<User> getUserByEmail(User user)
    {
        return userrepo.findByEmail(user.getEmail());
    }
    public void addNewUser(User user)
    {
        Optional<User> USERoPTION = userrepo.findByEmail(user.getEmail());
        if(USERoPTION.isPresent())
        {
            throw  new IllegalStateException("EMAIL IS ALREADY TAKEN ");
        }
        userrepo.save(user);
    }
    public User updateUser(User user )
    {
        User user1 =userrepo.findByEmail(user.getEmail()).orElseThrow();
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setCountry(user.getCountry());

        return user1 ;

    }
    public void deleteUser(Long id )
    {
        boolean exist = userrepo.existsById(id);
        if(!exist)
        {
            throw new IllegalStateException("User does not  exist");
        }
        userrepo.deleteById(id);
    }
}
