package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.Permission;

import java.util.List;

@Repository
public interface PermissionMapper {
    Permission selectByName(String name);

    void insertPermission(Permission permission);

    void deletePermission(Permission permission);

    void updatePermission(Permission permission);

    List<Permission> selectAllPermission();
}
