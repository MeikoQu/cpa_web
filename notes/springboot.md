# Spring Boot 

1. 创建maven工程
2. 导入spring-boot-starter-web起步依赖（idea自动导入)
 * 会自动扫描启动类下包及其子包
3. 编写controller
4. 提供启动类


## Springboot提供了多种配置文件
### properties
手动修改port number or context path
```
server.port=9090
server.servlet.context-path=/start
```

### yml文件
层级表示更清楚
```
server:
  port: 9191
  servlet:
    context-path: /start
```
书写与获取
1. 比如引入redis，先引入依赖，根据文档添加配置信息
2. 自定义配置，实体类的封装，配置信息的书写如下：
```
email:
    user: meikoqu@gmail.com
    code: xscsvdsxkchnw
    host: gmail.com
    auth: true
    
 # 还可以用数组来配置
```
再说配置信息的获取：在实体类里对应的成员变量上 @Value(${键名})   EL表达式
```
public class EmailProperties{

    @Value(${email.user})
    public String user;
```
这样如果成员变量太多，一个个去@Value太麻烦，可以借用在实体类上 @ConfigurationProperties(prefix="email") 来自动封装
```
@Component
@ConfigurationProperties(prefix = 'email')
public class EmailProperties{

    @Value(${email.user})
```
浏览器 --> UserController --> UserService --> UserMapper --> Database

### Bean注册
| 注解          | 说明              | 位置                         |
|-------------|-----------------|----------------------------|
| @Component  | 声明bean的基础注解     | 不属于以下三类时，用此注解              |
| @Controller | @Component的衍生注解 | 标注在控制器类上                   |
| @Service    | @Component的衍生注解 | 标注在业务类上                    |
| @Repository | @Component的衍生注解 | 标注在数据访问类上（由于与mybatis整合，用的少 |


### Spring Validation
spring提供的一个参数校验框架，使用预定义的注解完成参数校验，如果说是校验password和username是否符合要求。
1. import spring validation dependency
2. 在参数前面添加@Pattern注解，加正则表达式，eg: @Pattern(regexp = "^//${5,16}$")
3. 在Controller类上添加@Validated注解

验证后，网页上返回的是500错误，我们需要全剧异常处理器，来处理参数validation error。

### 

