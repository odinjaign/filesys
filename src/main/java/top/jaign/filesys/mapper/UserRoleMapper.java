package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.UserRole;

@Repository
public interface UserRoleMapper {
    UserRole selectByUsername(String username);
}
