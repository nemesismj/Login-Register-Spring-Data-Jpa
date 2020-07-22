package kz.iitu.cs.demo.Controller;

import kz.iitu.cs.demo.Model.Item;
import kz.iitu.cs.demo.Model.User;
import kz.iitu.cs.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "registerform";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        //List<String> allUsernames = userService.getAllUsersUsernames();
        String username = user.getUsername();
        String password = user.getPassword();
        String fname = user.getFname();
        String lname = user.getLname();
        String role = user.setRole("USER");
        String repeatedPassword = user.getRepeatedPassword();
        if (bindingResult.hasErrors() || !password.equals(repeatedPassword)) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "registerform";
        }
        else {
            userService.saveUser(user);
            return "redirect:/login"; }
    }

    @RequestMapping(value = "/login")
    public String login() {

        return "login";

    }

}
