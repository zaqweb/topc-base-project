package co.topc.base.auth.service.impl;

import co.topc.base.auth.entity.Role;
import co.topc.base.auth.entity.req.QueryRequest;
import co.topc.base.auth.mapper.IUserRolePermissionMapper;
import co.topc.base.auth.service.IRoleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MrBird
 */
@Service
@Primary
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IUserRolePermissionMapper userRolePermissionMapper;

    @Override
    public Page<Role> findRoles(Role role, QueryRequest request) {
        return null;
    }

    @Override
    public List<Role> findUserRole(String userName) {
        return userRolePermissionMapper.findUserRole(userName);
    }

    @Override
    public Role findByName(String roleName) {
        return null;
    }

    @Override
    public void createRole(Role role) {

    }

    @Override
    public void deleteRoles(String[] roleIds) throws Exception {

    }

    @Override
    public void updateRole(Role role) throws Exception {

    }
}
