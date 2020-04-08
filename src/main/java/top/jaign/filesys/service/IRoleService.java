package top.jaign.filesys.service;

import top.jaign.filesys.entity.Role;

public interface IRoleService {
    Role findRoleByName(String name);

    boolean addPermission2Role(String roleName, String permissionName);

    boolean removePermission4Role(String roleName, String permissionName);

    boolean roleHavePermission(String roleName, String permissionName);

    boolean roleExist(String roleName);

    void addRole(Role role);
    void deleteRole(Role role);
    void updateRole(Role role);
}
