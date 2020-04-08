package top.jaign.filesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jaign.filesys.entity.Permission;
import top.jaign.filesys.mapper.PermissionMapper;
import top.jaign.filesys.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {


    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission findPermissionByName(String name) {
        return permissionMapper.selectByName(name);
    }

    @Override
    public void addPermission(Permission permission) {
        permissionMapper.insertPermission(permission);
    }

    @Override
    public void deletePermission(Permission permission) {
        permissionMapper.deletePermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }
}
