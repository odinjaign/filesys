package top.jaign.filesys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorizationController {


    /**
     * 新增页
     */
    @RequestMapping("/add")
    public String add() {
        return "authorization/add";
    }

    /**
     * 删除页
     */
    @RequestMapping("/delete")
    public String delete() {
        return "authorization/delete";
    }

    /**
     * 更新页
     */
    @RequestMapping("/update")
    public String update() {
        return "authorization/update";
    }
}
