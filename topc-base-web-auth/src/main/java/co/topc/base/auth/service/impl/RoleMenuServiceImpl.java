package co.topc.base.auth.service.impl;

import co.topc.base.auth.service.IRoleMenuService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fantao
 * @date 2019-07-14 17:39
 */
@Service
@Primary
public class RoleMenuServiceImpl implements IRoleMenuService {

    @Override
    public void deleteRoleMenusByRoleId(List<String> roleIds) {

    }

    @Override
    public void deleteRoleMenusByMenuId(List<String> menuIds) {

    }

    @Override
    public void deleteRoleMenus(String menuId) {

    }
}
