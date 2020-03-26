package com.wang.mapper;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    Logger logger =  Logger.getLogger(UserMapperTest.class);

    @Test
    public void testQuery(){
        List<User> list =  MybatisUtils.getConnection().getMapper(UserMapper.class).queryUserList();
        for (User user:list  ) {
            System.out.println(user);
        }
    }


    @Test
    public void testQueryOne(){
        User user =  MybatisUtils.getConnection().getMapper(UserMapper.class).queryUserById(1);
        System.out.println(user);

    }

    @Test
    public  void testLog4J(){
        logger.debug("测试log4j的日志输出功能..........."+new Date());
    }

    @Test
    public  void testLimit(){
        HashMap<String,Integer> map = new HashMap();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list =  MybatisUtils.getConnection().getMapper(UserMapper.class).queryUsersByLimit(map);
        for (User user:list  ) {
            System.out.println(user);
        }
    }
}
