# Librarian
大三下学期软件过程与项目管理作业，使用jsp，servlet，mybatis等完成一个图书管理员的web系统。



## 环境准备

- jdk 11.0.7
- maven 3.6.3
- MySQL 8.0.20
- Tomcat 9.0.35



## 部署方法

1. 下载好项目文件并配置好所有环境后，先在 MySQL 环境下运行脚本 `library.sql`。  
2. 在 `/src/main/resources/mybatis-config.xml` 中配置好 MySQL 的连接。
3. 在 `pom.xml` 所在目录下运行命令 `mvn clean package` 生成 `Librarian.war` 并将它放在 `tomcat根目录/webapps/` 下。
4. 启动 Tomcat，访问 localhost:8080/Librarian。