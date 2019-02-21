# jetty&tomcat
## 比较
 * [详解web容器 - Jetty与Tomcat孰强孰弱 - 北岛知寒 - 博客园](https://www.cnblogs.com/crazyacking/p/5734849.html)

## tomcat

## jetty

### jetty和netty的关系
完全两码子事，仅仅是有个etty的后缀一样，这就像胖大海和大海一样，毫无关系
  1. Jetty是一个Web服务器（HTTP），与Tomcat等类似，但比大多数servlet容器更轻。这更接近传统的Java服务器应用程序（servlet，WAR文件）的方式。像Netty一样，它足够轻量级以嵌入到Java应用程序中。
  2. Netty是一款NIO客户端服务器框架，可以快速轻松地开发协议服务器和客户端等网络应用程序。它极大地简化并简化了TCP和UDP套接字服务器等网络编程。因此Netty专注于帮助编写NIO /非阻塞异步网络程序。
