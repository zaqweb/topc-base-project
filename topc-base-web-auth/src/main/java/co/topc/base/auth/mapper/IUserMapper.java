package co.topc.base.auth.mapper;

import co.topc.base.auth.entity.User;
import co.topc.base.auth.entity.UserExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserDAO继承基类
 */
@Mapper
public interface IUserMapper extends MyBatisBaseDao<User, String, UserExample> {
}