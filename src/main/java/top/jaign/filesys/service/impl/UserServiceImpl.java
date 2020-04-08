package top.jaign.filesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jaign.filesys.entity.*;
import top.jaign.filesys.mapper.*;
import top.jaign.filesys.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


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
        //判断角色是否存在
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            System.out.println("用户不存在");
            return false;
        }
        Role role = roleMapper.selectByName(rolename);


        return false;
    }
}
