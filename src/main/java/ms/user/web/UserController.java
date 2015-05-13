package ms.user.web;

import ms.user.User;
import ms.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public User findUser(@PathVariable(value = "id") String id) {
        return service.findById(id);
    }
}
