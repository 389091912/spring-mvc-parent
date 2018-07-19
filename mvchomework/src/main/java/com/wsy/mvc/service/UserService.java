package com.wsy.mvc.service;

import com.github.pagehelper.PageInfo;
import com.wsy.mvc.entity.User;
import com.wsy.mvc.exception.UserExistException;
import com.wsy.mvc.exception.UserFindErrorException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 17:14
 */
public interface UserService {

    public void addUser(User user) throws UserExistException;

    public void modify(User user) throws UserExistException;

    public void deleteById(Integer id);

    public User selectUserById(Integer id);

    public PageInfo<User> selectAll(int pageNo, User user);

    public List<User> selectAllUserList(User user);

    public User selectByUsernameAndPassword(User user) throws UserFindErrorException;

}
