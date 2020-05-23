1. MySQL分库分表经验, 原则
2. 线上的大表 mysql执行alert语句
3. Buffer Pool简介， mysql commit之后是否写磁盘
    * https://blog.csdn.net/xuanxuan_good/article/details/72639198
    * [MySQL磁盘写入策略以及数据安全性的相关参数 - 叮伱格斐呃 - 博客园](https://www.cnblogs.com/dannylinux/p/9828800.html)
    * [关于MySQL的commit非规律性失败案例的深入分析 - long0801的博客 - CSDN博客](https://blog.csdn.net/long0801/article/details/77123696)
    ```
    sql server 直接写硬盘.
    oracle,先放到缓存中,commit后直接写硬盘.
    mysql,不知道原理,帮顶.
    ```
    https://www.cnblogs.com/f-ck-need-u/archive/2018/05/08/9010872.html
4. MMM & PXC
5. Mysql bingo
6. mysql 索引， 索引的分类
7. mysql事务的原理
8. mysql 锁
9. mysql 隔离级别
10. mysql主从复制
11. mysql qunar的高可用架构图
12. 关系型和非关系型数据库区别
13. 数据库连接池.
14. 读写分离的好处
15. mysql慢查询排查与优化
16. mvcc详解
17. next-key 详解
18. 快照度？当前读
 https://blog.csdn.net/silyvin/article/details/79280934
19. 三大范式
 https://www.cnblogs.com/knowledgesea/p/3667395.html

2018Q3-美团点评数据库月报： https://km.sankuai.com/page/60818667
