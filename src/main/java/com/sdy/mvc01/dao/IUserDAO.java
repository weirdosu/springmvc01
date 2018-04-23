package com.sdy.mvc01.dao;

import com.sdy.mvc01.entity.User;

import java.util.List;

/**
 * 用户访问数据接口
 */
public interface IUserDAO {
    List<User> getAll();

    User getUserById(int id);

    boolean add(User user);

    boolean delete(int id);

    boolean update(User user);
}
