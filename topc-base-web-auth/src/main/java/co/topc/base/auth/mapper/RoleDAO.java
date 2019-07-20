package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.Role;
import co.topc.base.auth.entity.RoleExample;
import org.springframework.stereotype.Repository;

/**
 * RoleDAO继承基类
 */
@Repository
public interface RoleDAO extends MyBatisBaseDao<Role, String, RoleExample> {
}