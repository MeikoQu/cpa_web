## 环境搭建
1. 准备database
2. 创建springboot project，引入对应的依赖（web. mybatis, mysql驱动）
3. 配置文件application.yml中引入mybatis的配置信息
4. 创建包结构，并准备实体类

## User class
### 1. register

### 2. login: \
user登陆成功后，系统会自动下发JWT token，然后在后续的每次请求中，浏览器都需要在请求头header中携带到服务端，请求头的名称为Authorization，值为登陆时下发的JWT token。 \
如果检测到用户未登陆，则http响应状态码为401。
3. fetch user information
4. update user information
5. update user profile
6. update user password

lombok为实体类自动生成getset和toString方法，pom文件中引入依赖后，在实体类上添加注解@Data



