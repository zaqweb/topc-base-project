package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.Menu;
import co.topc.base.auth.entity.MenuExample;
import org.springframework.stereotype.Repository;

/**
 * MenuDAO继承基类
 */
@Repository
public interface MenuDAO extends MyBatisBaseDao<Menu, String, MenuExample> {
}