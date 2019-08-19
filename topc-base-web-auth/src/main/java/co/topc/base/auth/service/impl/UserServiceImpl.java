package co.topc.base.auth.service.impl;

import co.topc.base.auth.util.TopcMD5Util;
import co.topc.web.commons.constants.TopcStringConstant;
import co.topc.base.auth.entity.User;
import co.topc.base.auth.entity.UserExample;
import co.topc.base.auth.entity.UserRole;
import co.topc.base.auth.entity.req.QueryRequest;
import co.topc.base.auth.mapper.IUserMapper;
import co.topc.base.auth.service.IUserRoleService;
import co.topc.base.auth.service.IUserService;
import com.github.pagehelper.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author fantao
 * @date 2019/7/14 9:47
 */
@Service
@Primary
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User findByName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(users)) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLoginTime(String username) {
        User user = new User();
        user.setLastLoginTime(new Date());

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);

        userMapper.updateByExampleSelective(user, userExample);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) {
        user.setCreateDate(new Date());
        user.setStatus(User.STATUS_VALID);
        user.setPassword(TopcMD5Util.encrypt(user.getUserName(), User.DEFAULT_PASSWORD));

        userMapper.insert(user);
        // 保存用户角色
        String[] roles = user.getRoleId().split(TopcStringConstant.COMMA);
        setUserRoles(user, roles);
    }

    @Override
    public void deleteUsers(String[] userIds) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void resetPassword(String[] usernames) {

    }

    @Override
    public void regist(String username, String password) {

    }

    @Override
    public void updatePassword(String username, String password) {

    }

    @Override
    public void updateAvatar(String username, String avatar) {

    }

    @Override
    public void updateProfile(User user) {

    }

    private void setUserRoles(User user, String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();
        Arrays.stream(roles).forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(roleId);
            userRoles.add(ur);
        });
//        userRoleService.saveBatch(userRoles);
    }

    @Override
    public Page<User> findUserDetail(User user, QueryRequest queryRequest) {
        return null;
    }

    @Override
    public User findByUserNamePassword(String userName, String password) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(users)) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
