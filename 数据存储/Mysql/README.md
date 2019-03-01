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
20. 主从复制&&主主复制：
    操作流程 https://www.cnblogs.com/nbuntu/p/5523331.html
    所有参数 https://www.cnblogs.com/qianniao12/p/8011222.html
    1. 正常场景
      ```
      1. 锁表，
      2. 重置slave为master，把变成可以同步的,
      3. 降级主库,
      4. 同步数据,
      5. 开启.
      ```
    2. 异常场景
      ```
      1. stop Slave
      2. 注释readOnly=1
      3. resetMaster
      4. stopSlave，change master to master_host='IP'
      ```
21. spring主从数据库方案 https://blog.csdn.net/qq_37878879/article/details/78416520
22. mysql 多级缓存 https://www.cnblogs.com/maoyizhimi/p/7778504.html
23. 允许批量更新
  allowMultiQueries=true
24. MyIsam http://www.cnblogs.com/y-rong/p/8110596.html
