package top.jaign.filesys.service;

import top.jaign.filesys.entity.User;

public interface IUserService {

    //根据用户名查询用户所有信息，包括角色和权限
    User findUserByUsername(String username);

    boolean addRole2User(String username,String rolename);
}
