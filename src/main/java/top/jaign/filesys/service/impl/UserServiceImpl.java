package top.jaign.filesys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jaign.filesys.entity.*;
import top.jaign.filesys.mapper.*;
import top.jaign.filesys.service.IUserService;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public User findUserByUsername(String username) {
        //查询用户
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            logger.info("用户不存在");
            return null;
        }
        //查询用户角色
        List<UserRole> userRoles = userRoleMapper.selectByUsername(username);
        List<Role> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = roleMapper.selectByName(userRole.getRoleName());
            //查询角色权限
            List<Permission> permissions = new ArrayList<>();
            List<RolePermission> rolePermissions = rolePermissionMapper.selectByRoleName(role.getName());
            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionMapper.selectByName(rolePermission.getPermissionName());
                permissions.add(permission);
            }
            role.setPermissions(permissions);
            roles.add(role);
        }
        user.setRoles(roles);
        return user;
    }

    @Override
    public boolean addRole2User(String username, String rolename) {
        UserRole userRole = new UserRole();
        userRole.setUserName(username);
        userRole.setRoleName(rolename);
        userRoleMapper.insertUserRole(userRole);
        return true;
    }

    @Override
    public boolean removeRole4User(String username, String rolename) {
        UserRole userRole = new UserRole();
        userRole.setUserName(username);
        userRole.setRoleName(rolename);
        userRoleMapper.removeUserRole(userRole);
        return false;
    }

    @Override
    public boolean userHaveRole(String username, String rolename) {
        UserRole userRole = new UserRole();
        userRole.setUserName(username);
        userRole.setRoleName(rolename);
        if (userRoleMapper.selectUserRole(userRole) == null) {
            return false;
        } else
            return true;
    }

    @Override
    public boolean userExist(String username) {
        if (userMapper.selectByUsername(username) == null) {
            return false;
        } else
            return false;
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
