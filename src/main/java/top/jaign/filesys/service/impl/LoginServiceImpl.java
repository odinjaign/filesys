package top.jaign.filesys.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import top.jaign.filesys.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {


    @Override
    public ResponseEntity login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);// 执行认证登陆
        return ResponseEntity.ok("{\"message\":\"登陆成功\"}");
    }

    @Override
    public ResponseEntity logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseEntity.ok("{\"message\":\"登出成功\"}");
    }

}