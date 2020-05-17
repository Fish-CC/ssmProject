package com.ssm.apps.service.impl;

import com.ssm.apps.domain.UserInfo;
import com.ssm.apps.mapper.UserMapper;
import com.ssm.apps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public void save(UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        userMapper.save(userInfo);
    }

    public UserInfo selectUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    public List<UserInfo> findUser() {
        return userMapper.findUser();
    }
}
