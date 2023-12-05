package ejercicios.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.User;
import ejercicios.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userService.userPerId(id);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
        User userSelected = userService.userPerId(id);

        // Update userSelected with values from userDTO
        userSelected.setUsername(user.getUsername());
        userSelected.setPass(user.getPass());
        userSelected.setEmail(user.getEmail());
        userSelected.setSteamUsername(user.getSteamUsername());

        return userService.updateUser(userSelected);
    }
}
