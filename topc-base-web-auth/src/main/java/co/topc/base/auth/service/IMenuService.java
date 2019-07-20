package co.topc.base.auth.service;

import co.topc.base.auth.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
public interface IMenuService {

    List<Menu> findUserPermissions(String username);

    List<Menu> findUserMenus(String username);

    Map<String, Object> findMenus(Menu menu);

    List<Menu> findMenuList(Menu menu);

    void createMenu(Menu menu);

    void updateMenu(Menu menu) throws Exception;

    /**
     * 递归删除菜单/按钮
     *
     * @param menuIds menuIds
     */
    void deleteMeuns(String[] menuIds) throws Exception;
}
