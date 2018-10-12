package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemotransactionApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(DemotransactionApplicationTests.class);

    @Autowired
    private UserService userService ;
    /**
     *  1.Springboot 默认没有管理事务
     *  2.输出事务执行过程日志
     *
     */
    @Test
    public  void testInsert1(){
        // 测试事务
        User user = new  User();
        user.setName("testInsert1");
        userService.insert(user);
    }

    @Test
    public  void testInsert2(){
        logger.info(" testInsert2 start transaction ........");
        // 测试事务
        User user = new  User();
        user.setName("testInsert2");
        userService.insert2(user);
        logger.info("testInsert2 end transaction ........");
    }

    @Test
    public  void testInsert3(){
        // 测试事务
        User user = new  User();
        user.setName("testInsert3");
        userService.insert3(user);
    }


}
