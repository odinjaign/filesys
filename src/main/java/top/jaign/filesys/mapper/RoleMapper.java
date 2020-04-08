package top.jaign.filesys.mapper;

import top.jaign.filesys.entity.Role;

public interface RoleMapper {
    Role selectByName(String name);
}
