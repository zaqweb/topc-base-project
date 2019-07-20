package co.topc.base.auth.service;

import co.topc.base.auth.entity.User;
import co.topc.base.auth.entity.req.QueryRequest;
import com.github.pagehelper.Page;

/**
 * @author fantao
 * @date 2019/7/14 9:47
 */
public interface IUserService {

    /**
     * 通过用户名查找用户
     *
     * @param username username
     * @return user
     */
    User findByName(String username);

    /**
     * 查询用户详情，包括基本信息，用户角色，用户部门
     *
     * @param user         user
     * @param queryRequest queryRequest
     * @return IPage
     */
    Page<User> findUserDetail(User user, QueryRequest queryRequest);

    /**
     * 更新用户登录时间
     *
     * @param username username
     */
    void updateLoginTime(String username) throws Exception;

    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(User user) throws Exception;

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUsers(String[] userIds) throws Exception;

    /**
     * 更新个人信息
     *
     * @param user 个人信息
     */
    void updateProfile(User user) throws Exception;

    /**
     * 更新用户头像
     *
     * @param username 用户名
     * @param avatar   用户头像
     */
    void updateAvatar(String username, String avatar) throws Exception;

    /**
     * 更新用户密码
     *
     * @param username 用户名
     * @param password 新密码
     */
    void updatePassword(String username, String password) throws Exception;

    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     */
    void regist(String username, String password) throws Exception;

    /**
     * 重置密码
     *
     * @param usernames 用户集合
     */
    void resetPassword(String[] usernames) throws Exception;
}
