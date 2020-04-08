package top.jaign.filesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jaign.filesys.entity.User;
import top.jaign.filesys.entity.UserRole;
import top.jaign.filesys.mapper.UserMapper;
import top.jaign.filesys.mapper.UserRoleMapper;
import top.jaign.filesys.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User findUserByUsername(String username) {
        UserRole userRole = userRoleMapper.selectByUsername(username);
        return userMapper.selectByUsername(username);
    }
}
