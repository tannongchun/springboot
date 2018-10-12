## Spring 事务 

###  解决场景 

- 次业务异常，不影响主业务


#### 解决方案1

> UserService userService = (UserService) AopContext.currentProxy();
> userService.insert3(user);


#### 解决方案2

````
  @Autowired
    private ApplicationContext context;
  
    private UserService userService;
  
    @PostConstruct
    public void init(){
      userService =context.getBean(UserService.class);
    }
   
````

#### 输出 Spring 内的日志
```
    debug=true
    logging.path=./
    logging.level.root=INFO
    # 输出 springframework 的日志
    logging.level.org.springframework=DEBUG

```