package top.jaign.filesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jaign.filesys.entity.Permission;
import top.jaign.filesys.entity.Role;
import top.jaign.filesys.entity.RolePermission;
import top.jaign.filesys.mapper.PermissionMapper;
import top.jaign.filesys.mapper.RoleMapper;
import top.jaign.filesys.mapper.RolePermissionMapper;
import top.jaign.filesys.service.IRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {


    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public Role findRoleByName(String name) {
        Role role = roleMapper.selectByName(name);
        //查询权限
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByRoleName(name);
        List<Permission> permissions = new ArrayList<>();
        for (RolePermission rolePermission : rolePermissions) {
            //查询具体权限
            Permission permission = permissionMapper.selectByName(rolePermission.getPermissionName());
            permissions.add(permission);
        }
        role.setPermissions(permissions);
        return role;
    }


    @Override
    public boolean addPermission2Role(String roleName, String permissionName) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleName(roleName);
        rolePermission.setPermissionName(permissionName);
        rolePermissionMapper.insertRolePermission(rolePermission);
        return true;
    }

    @Override
    public boolean removePermission4Role(String roleName, String permissionName) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleName(roleName);
        rolePermission.setPermissionName(permissionName);
        rolePermissionMapper.removeRolePermission(rolePermission);
        return true;
    }

    @Override
    public boolean roleHavePermission(String roleName, String permissionName) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleName(roleName);
        rolePermission.setPermissionName(permissionName);
        if (rolePermissionMapper.selectRolePermission(rolePermission) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean roleExist(String roleName) {
        if (roleMapper.selectByName(roleName) == null) {
            return false;
        }
        return true;
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insertRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }
}
