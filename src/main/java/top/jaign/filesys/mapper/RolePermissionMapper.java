package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.RolePermission;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    List<RolePermission> selectByRoleName(String rolename);
}
