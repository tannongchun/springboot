package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @version 1.0
 * @description:
 * @projectName: com.example.demo.service.impl
 * @className: demotransaction
 * @author:谭农春
 * @createTime:2018/10/12 8:57
 */
@Transactional
@Service
public class UserServiceImpl implements  UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private ApplicationContext context;

  private UserService userService;

  @PostConstruct
  public void init(){
    userService =context.getBean(UserService.class);
  }


  // 插入用户是否嵌套测试
  @Override
  public  void insert(User user){
    userMapper.insert(user);
  }
  // 插入用户是否嵌套测试
  @Transactional
  @Override
  public  void insert2(User user){
    // 数据库无数据》》》》》》
    // insert3 抛出异常
//    insert3(user);
    //》》》》》》》》》》》》》
    try{
//      insert3(user);  调用代理
//      UserService userService = (UserService) AopContext.currentProxy();
      userService.insert3(user);
    }catch (Exception e){
      e.printStackTrace();
    }
    userMapper.insert(user);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void insert3(User user) {
    userMapper.insert(user);
     int a = 1/0;
  }

  // 数据库隔离级别说明
  // read uncommitted 读取未提交的事务。 所有事务都可以看到未提交事务的结果。读取未提交的结果“脏读”
  // read committed  同一语句执行两次，看到不同结果。
  // repeatable read 确保同一事务的多个实例在并发读取数据时，会看到同样的数据。引出的问题是幻读：读取某一区间，，另外事务插入新数据，结果不一致。



}
