package top.jaign.filesys.service;

import top.jaign.filesys.entity.Role;

public interface IRoleService {
    Role findRoleByName(String name);
}
