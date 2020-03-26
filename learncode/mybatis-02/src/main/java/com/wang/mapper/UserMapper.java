package com.wang.mapper;

import com.wang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    List<User> queryUsersByLimit(Map map);
}
