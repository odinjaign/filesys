package top.jaign.filesys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.jaign.filesys.service.impl.LoginServiceImpl;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginApiFacade {

    @Resource
    private LoginServiceImpl loginServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(LoginApiFacade.class);
    /**
     * 登陆 API
     *
     * @param params 包含必传信息 用户名 密码
     */
    @RequestMapping(value = "/open/api/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Map<String, String> params) {
        if (params.containsKey("username") && params.containsKey("password")) {
            String username = params.get("username");
            String password = params.get("password");
            return loginServiceImpl.login(username, password);
        } else {
            return ResponseEntity.badRequest().body("{\"message\":\"缺少重要参数或参数无效\"}");
        }
    }

    /**
     * 登出 API
     */
    @RequestMapping(value = "/open/api/logout", method = RequestMethod.POST)
    public ResponseEntity logout() {
        return loginServiceImpl.logout();
    }

}