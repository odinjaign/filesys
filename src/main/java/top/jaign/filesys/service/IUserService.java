package top.jaign.filesys.service;

import top.jaign.filesys.entity.User;

public interface IUserService {
    User findUserByUsername(String username);
}
