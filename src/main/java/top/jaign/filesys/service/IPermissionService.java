package top.jaign.filesys.service;

import top.jaign.filesys.entity.Permission;

import java.util.List;

public interface IPermissionService {
    Permission findPermissionByName(String name);
    void addPermission(Permission permission);
    void deletePermission(Permission permission);
    void updatePermission(Permission permission);
    List<Permission> findAllPermissions();
}
