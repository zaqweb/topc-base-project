package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.RoleMenu;
import co.topc.base.auth.entity.RoleMenuExample;
import org.springframework.stereotype.Repository;

/**
 * RoleMenuDAO继承基类
 */
@Repository
public interface RoleMenuDAO extends MyBatisBaseDao<RoleMenu, String, RoleMenuExample> {
}