package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.Menu;
import co.topc.base.auth.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fantao
 * @date 2019/7/15 23:38
 */
@Mapper
public interface IUserRolePermissionMapper {

    List<Role> findUserRole(String userName);

    List<Menu> findUserPermissions(String userName);
}
