package top.jaign.filesys.mapper;

import org.springframework.stereotype.Repository;
import top.jaign.filesys.entity.User;

@Repository
public interface UserMapper {
    User selectByUsername(String username);

    void insertUser(User user);

    void deleteUser(User user);

    void updateUser(User user);
}
