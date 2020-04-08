package top.jaign.filesys.mapper;

import top.jaign.filesys.entity.Permission;

public interface PermissionMapper {
    Permission selectByName(String name);
}
