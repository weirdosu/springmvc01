package com.sdy.mvc01.dao;

import com.sdy.mvc01.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据访问对象
 */
@Repository
public class UserDAO implements IUserDAO {
    private static List<User> users= new ArrayList<User>();

    static{
        users.add(new User(1,"刘德华","中国香港","17862716176"));
        users.add(new User(2,"张学友","中国广东","17862716177"));
        users.add(new User(3,"张国立","中国北京","17862716178"));
        users.add(new User(4,"张靓颖","中国上海","17862716179"));
        users.add(new User(5,"苏殿元","中国河北","17862716180"));
        users.add(new User(6,"齐萍萍","中国珠海","17862716181"));
    }
    /**获得所有*/
    public List<User> getAll() {
        return users;
    }
    /**单个用户*/
    public User getUserById(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    /**添加*/
    public boolean add(User user){
        if(user.getId()<=0){
            user.setId(users.get(users.size()-1).getId()+1);
        }
        users.add(user);
        return true;
    }
    /**删除*/
    public boolean delete(int id){
        users.remove(getUserById(id));
        return true;
    }
    /**更新*/
    public boolean update(User user){
        User oldUser = getUserById(user.getId());
        oldUser.setName(user.getName());
        oldUser.setAddress(user.getAddress());
        oldUser.setPhone(user.getPhone());
        return true;
    }
}
