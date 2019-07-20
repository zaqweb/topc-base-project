package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.UserRole;
import co.topc.base.auth.entity.UserRoleExample;
import org.springframework.stereotype.Repository;

/**
 * UserRoleDAO继承基类
 */
@Repository
public interface UserRoleDAO extends MyBatisBaseDao<UserRole, String, UserRoleExample> {
}