package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.Permission;

@Repository
public interface PermissionMapper {
    Permission selectByName(String name);
    void addPermission(Permission permission);
}
