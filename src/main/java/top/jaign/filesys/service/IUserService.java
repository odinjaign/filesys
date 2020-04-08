package top.jaign.filesys.service;

import top.jaign.filesys.entity.User;

public interface IUserService {

    //根据用户名查询用户所有信息，包括角色和权限
    User findUserByUsername(String username);

    // 添加角色
    boolean addRole2User(String username,String rolename);

    // 移除角色
    boolean removeRole4User(String username,String rolename);

    // 是否存在此角色
    boolean userHaveRole(String username,String rolename);

    //用户是否存在
    boolean userExist(String username);

    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
