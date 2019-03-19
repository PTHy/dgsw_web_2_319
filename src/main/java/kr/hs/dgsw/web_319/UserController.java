package kr.hs.dgsw.web_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> user() {
        return this.userService.userList();
    }

    @GetMapping("/user/{idx}")
    public User view(@PathVariable int idx) {
        return this.userService.view(idx);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
        return this.userService.add(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @DeleteMapping("/user/{idx}")
    public boolean delete(@PathVariable int idx) {
        return this.userService.delete(idx);
    }
}

// CRUD Create Read   Update Delete
// SQL  insert select update delete
// HTTP POST   GET    PUT    DELETE