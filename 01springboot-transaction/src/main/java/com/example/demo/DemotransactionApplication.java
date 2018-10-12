package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 启用事务管理
@MapperScan("com.example.demo.mapper") // mybatis 扫描 mapper 文件
public class DemotransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemotransactionApplication.class, args);
	}
}
