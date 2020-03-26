package com.wang.mybatis.dao;

import com.wang.mybatis.pojo.User;
import com.wang.mybatis.utils.MybatisUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.annotation.Generated;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public  void test01(){
//        第一步，获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSessioin();
//        执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.findUsers();
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public  void testFindOne(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
        User user =sqlSession.getMapper(UserMapper.class).findUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
        User user  = new User(null,"zhipan",null,"m","chengdu");
        sqlSession.getMapper(UserMapper.class).saveUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public  void testUpdate(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
        Date date = new Date();
        User user  = new User(4,"zhipan",date,"m","chengdu");
        sqlSession.getMapper(UserMapper.class).updateUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public  void testDelete(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
        sqlSession.getMapper(UserMapper.class).deleteUserById(2);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public  void testMap(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
        Map map = new HashMap();
//        利用map传入表字段username的值，调用对应方法insert 到表里面
        map.put("userName","wangzhipan");
        sqlSession.getMapper(UserMapper.class).saveUserByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void testLike(){
        SqlSession sqlSession = MybatisUtils.getSessioin();
//        模糊查询，在入参中组装 %%
        List<User> userList =sqlSession.getMapper(UserMapper.class).findUsersByLike("%wang%");
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
