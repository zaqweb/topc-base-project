package co.topc.base.auth.service.impl;

import co.topc.base.auth.service.IUserRoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MrBird
 */
@Service
@Primary
public class UserRoleServiceImpl implements IUserRoleService {


    @Override
    public void deleteUserRolesByRoleId(List<String> roleIds) {

    }

    @Override
    public void deleteUserRolesByUserId(List<String> userIds) {

    }
}
