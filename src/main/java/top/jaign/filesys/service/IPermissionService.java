package top.jaign.filesys.service;

import top.jaign.filesys.entity.Permission;

public interface IPermissionService {
    Permission findPermissionByName(String name);
}
