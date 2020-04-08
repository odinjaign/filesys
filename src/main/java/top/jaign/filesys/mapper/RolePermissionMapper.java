package top.jaign.filesys.mapper;

import top.jaign.filesys.entity.RolePermission;

public interface RolePermissionMapper {
    RolePermission selectByRoleName(String rolename);
}
