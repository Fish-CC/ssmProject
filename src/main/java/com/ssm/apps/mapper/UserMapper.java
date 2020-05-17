package com.ssm.apps.mapper;

import com.ssm.apps.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user (name ,username ,password, age , sex ,address, create_time) values (#{name,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR},#{age,jdbcType=INTEGER},#{sex,jdbcType=INTEGER},#{address,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(UserInfo userInfo);

    @Select("select * from t_user")
    List<UserInfo> findUser();

    UserInfo selectUserById(String userId);

}
