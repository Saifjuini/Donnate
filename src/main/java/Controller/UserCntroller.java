package Controller;

import Repository.UserRepository;
import Service.IntUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCntroller {
    @Autowired
    private IntUser iuser ;

    @Autowired
    private UserRepository userrepo ;

    @GetMapping("/register")
    public String showRegistrationform(Model model )
    {
        model.addAttribute("user",new User());
        return "sign-up";$
    }

    @PostMapping("Process_register")
    public String processingRegister(User user)
    {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String encondedpassword = passwordEncoder.encode((user.getPassword()));
        user.setPassword(encondedpassword);
        userrepo.save(user);
        return "register_success";
    }
    @GetMapping("/table_users")
    public String getallUsers(Model model)
    {
        model.addAttribute("userList",iuser.getUser());
        return "user_table";
    }

    @PostMapping()



}
