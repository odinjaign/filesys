package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.Role;

@Repository
public interface RoleMapper {
    Role selectByName(String name);
}
