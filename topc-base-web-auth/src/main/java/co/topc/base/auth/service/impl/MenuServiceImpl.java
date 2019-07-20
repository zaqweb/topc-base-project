package co.topc.base.auth.service.impl;

import co.topc.base.auth.entity.Menu;
import co.topc.base.auth.mapper.IUserRolePermissionMapper;
import co.topc.base.auth.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author fantao
 * @date 2019-07-14 17:39
 */
@Service
@Primary
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IUserRolePermissionMapper userRolePermissionMapper;

    @Override
    public List<Menu> findUserPermissions(String username) {
        return userRolePermissionMapper.findUserPermissions(username);
    }

    @Override
    public List<Menu> findUserMenus(String username) {
        return null;
    }

    @Override
    public Map<String, Object> findMenus(Menu menu) {
        return null;
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        return null;
    }

    @Override
    public void createMenu(Menu menu) {

    }

    @Override
    public void updateMenu(Menu menu) throws Exception {

    }

    @Override
    public void deleteMeuns(String[] menuIds) throws Exception {

    }
}
