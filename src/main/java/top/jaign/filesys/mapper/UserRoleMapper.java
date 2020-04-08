package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleMapper {
    List<UserRole> selectByUsername(String username);
    void insertUserRole(UserRole userRole);
    void removeUserRole(UserRole userRole);
    UserRole selectUserRole(UserRole userRole);
}
