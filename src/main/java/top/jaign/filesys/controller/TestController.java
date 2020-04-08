package top.jaign.filesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jaign.filesys.service.IUserService;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private IUserService userService;



    @RequestMapping("getUser/{username}")
    public String getUser(@PathVariable String username) {
        return userService.findUserByUsername(username).toString();
    }
}
