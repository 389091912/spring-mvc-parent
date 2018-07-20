package com.wsy.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsy.mvc.config.Constant;
import com.wsy.mvc.dao.UserMapper;
import com.wsy.mvc.entity.User;
import com.wsy.mvc.entity.UserExample;
import com.wsy.mvc.exception.UserExistException;
import com.wsy.mvc.exception.UserFindErrorException;
import com.wsy.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 17:17
 */
@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;


    @Override
    public void addUser(User user) throws UserExistException {
        UserExample example = new UserExample();

        example.or().andNameEqualTo( user.getName() );

        List<User> resultUsers=userDao.selectByExample( example );

        if (!resultUsers.isEmpty()) {
            throw new UserExistException( "用户名已存在" );
        }else{
            userDao.insertSelective( user );
        }

    }

    @Override
    public void modify(User user) throws UserExistException {

        UserExample example = new UserExample();
        
        example.or().andNameEqualTo( user.getName() );

        List<User> list = userDao.selectByExample( example );

     //  Boolean flag= ;

        if (list.stream().anyMatch(user1 -> !user.getId().equals( user1.getId() ))) {
            throw new UserExistException( "用户名已存在" );
        }

        userDao.updateByPrimaryKeySelective( user );


    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("删除操作");
        userDao.deleteByPrimaryKey( id );
    }

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectByPrimaryKey( id );
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<User> selectAll(int pageNo, User user) {

        PageHelper.startPage( pageNo, Constant.PAGE_SIZE );

        List<User> users = userDao.selectAll( user );

        users.forEach( s->System.out.println( "结果 ： "+s) );

        return new PageInfo<>(users);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> selectAllUserList(User user) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public User selectByUsernameAndPassword(User user) throws UserFindErrorException {
        UserExample example = new UserExample();
        example.or().andNameEqualTo( user.getName() ).andPasswordEqualTo( user.getPassword() );

        List<User> users = userDao.selectByExample( example );
        if (users.isEmpty()) {
            throw new UserFindErrorException( "用户名和密码错误" );
        }
        users.forEach( System.out::println );


        return users.get(0);
    }
}
