# 项目基本情况
1. 简单的SSM框架使用
2. 实现了查询、删除等功能

# SSM_BookSystem SSM框架基础

预览：

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/ssm_booksystem_1.jpg)

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/ssm_booksystem_2.jpg)

---

搭建过程：
---
IDEA创建工程的过程

打开IDEA ---> File  ---> new ---> project  ---> maven  ---> 

create from archetype ---> maven-archetype-webapp ---> 接下来一般默认即可

最后在main目录下新建java文件夹，并且mark as source root。

首先创建如下的目录结构即可：
```
├── java
│   └── cn
│       └── gojay
│           ├── dao
│           │   └── BookDao.java
│           ├── entity
│           │   └── Book.java
│           ├── service
│           │   ├── BookService.java
│           │   └── impl
│           │       └── BookServiceImpl.java
│           └── web
│               └── BookController.java
├── resources
│   ├── jdbc.properties
│   ├── logback.xml
│   ├── mapper
│   │   └── BookMapper.xml
│   ├── mybatis-config.xml
│   └── spring
│       ├── spring-dao.xml
│       ├── spring-service.xml
│       └── spring-web.xml
└── webapp
    ├── index.jsp
    └── WEB-INF
        ├── jsp
        │   ├── detail.jsp
        │   └── list.jsp
        └── web.xml
```

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/1.png)

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/2.png)

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/3.png)

![Image text](https://raw.githubusercontent.com/Gojay001/Demo/master/SSMTest/img/4.png)


第一步：配置Maven添加Spring、Spring MVC、Mybatis的依赖
---
```
1. 日志：实现slf4j接口并整合；（Junit）
2. 数据库：mysql、c3p0、DAO（mybatis、mabatis-spring）；
3. Servlet web：standard、jstl、jackson、servlet-api；
4. Spring：
(1) Spring dao：jdbc、tx；
(2) Spring core：core、beans、context；（test）
(3) Spring web：web、webmvc
```

详情请看:<a href="https://github.com/Gojay001/Demo/blob/master/SSMTest/pom.xml" target="_blank">pom.xml</a>

第二步：建立基础配置
---
```
1、建立数据库：导入sql文件
2、web.xml：配置SpringMVC需要加载的文件classpath:spring/spring-*.xml
3、jdbc.properties：driver、url、username、password
4、logback.xml
5、mybatis-config.xml：<settings> </settings>
```

详情请看:<a href="https://github.com/Gojay001/Demo/tree/master/SSMTest/src/main" target="_blank">包目录</a>

第三步：自定义类
---
```
java
│   └── cn
│       └── gojay
│           ├── dao
│           │   └── BookDao.java
│           ├── entity
│           │   └── Book.java
│           ├── service
│           │   ├── BookService.java
│           │   └── impl
│           │       └── BookServiceImpl.java
│           └── web
│               └── BookController.java
```

1. entity：pojo对象
2. dao：提供方法接口（与mapper映射）
3. service：提供方法接口（与controller匹配）
4. service.impl：@Service，实现service方法（调用dao层接口返回）
5. web：@Controller，进行业务处理（匹配url，调用service）

详情请看:<a href="https://github.com/Gojay001/Demo/tree/master/SSMTest/src/main/java/cn/gojay" target="_blank">自定义类</a>

第四步：进行容器配置及映射
---
```
1、mapper：与dao层映射，通过SQL语句实现数据库操作；
2、spring-dao：配置整合mybatis过程
(1) 配置数据库相关参数properties的属性；
(2) 配置数据库连接池；
(3) 配置SqlSessionFactory对象；
(4) 配置扫描dao接口包，注入到spring容器中；
3、spring-service：
(1) 扫描service包下使用注解的类型；
(2) 注入数据库连接池；
(3) 配置基于注解的声明式事务；
4、spring-web：
(1) 开启spring mvc注解；
(2) 加载静态资源；
(3) 配置视图解析器；
(4) 扫描web相关bean；
```

详情请看:<a href="https://github.com/Gojay001/Demo/tree/master/SSMTest/src/main/resources" target="_blank">查看具体内容</a>

第五步：页面开发
---
页面主要使用了bootstrap
详情请看:<a href="https://github.com/Gojay001/Demo/tree/master/SSMTest/src/main/webapp" target="_blank">查看具体内容</a>