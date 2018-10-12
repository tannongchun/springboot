package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;


public interface UserMapper {

  @Insert("INSERT INTO t_user (`name`) VALUES (#{name})")
  void insert(User user);

}
