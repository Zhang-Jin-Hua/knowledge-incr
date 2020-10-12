Java虚拟机规范: https://docs.oracle.com/javase/specs/jvms/se10/html/



1. 类成员的加载顺序 Done
2. jvm类加载过程 Done
3. jvm GC Root都有哪些 Done
4. jvm调优有过没? 讲FD的那个调优
5. JIT编译器优化
6. JVM：GC算法，基本GC流程、常用收集器优缺点， 内存划分,永久代对象如何 GC ， GC 有环怎么处理,谁会被 GC ，什么时候 GC, 如果想不被 GC 怎么办,如果想在 GC 中生存1次怎么办,jvm 如何分配直接内存， new 对象如何不分配在堆而是栈上，常量池解析，数组多大放在 JVM 老年代（不只是设置 PretenureSizeThreshold ，问通常多大，没做过一问便知），老年代中数组的访问方式，
7. Class.forName()，在jvm中都发生了什么
8. jvm工具
    命令行
    1. jps(jvm processor status)虚拟机进程状况工具
    2. jstat(jvm statistics monitoring)统计信息监视
    3. jinfo(configuration info for java)配置信息工具
    4. jmap(memory map for java)Java内存映射工具
    5. jhat(JVM Heap Analysis Tool)虚拟机堆转储快照分析工具
    6. jstack(Stack Trace for Java)Java堆栈跟踪工具
    7. HSDIS：JIT生成代码反汇编
9. 双亲委派模型中的方法
    findLoadedClass(),LoadClass(),findBootstrapClassOrNull(),findClass(),resolveClass()
