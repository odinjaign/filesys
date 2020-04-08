package top.jaign.filesys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆页
     */
    @RequestMapping("/login")
    public String login() {
        logger.info("访问登录页");
        return "login";
    }

    /**
     * 退出 后跳转登陆页
     */
    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    /**
     * 首页
     */
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * 未授权页
     */
    @RequestMapping({"/unauthorized"})
    public String unauthorized() {
        return "unauthorized";
    }

}