package co.topc.base.auth.service;

import co.topc.base.auth.entity.Role;
import co.topc.base.auth.entity.req.QueryRequest;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author fantao
 */
public interface IRoleService {

    Page<Role> findRoles(Role role, QueryRequest request);

    List<Role> findUserRole(String userName);

    Role findByName(String roleName);

    void createRole(Role role);

    void deleteRoles(String[] roleIds) throws Exception;

    void updateRole(Role role) throws Exception;
}
