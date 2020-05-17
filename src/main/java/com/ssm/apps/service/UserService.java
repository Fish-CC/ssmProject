package com.ssm.apps.service;

import com.ssm.apps.domain.UserInfo;

import java.util.List;

public interface UserService {

    void save(UserInfo userInfo);

    List<UserInfo> findUser();

    UserInfo selectUserById(String userId);
}
