# Kafka

## link链接
https://blog.csdn.net/lingbo229/article/details/80761778
## 问题

1. 如何保实现全局有序
    https://yezhwi.github.io/bigdata/2018/05/25/Kafka%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98%E6%80%BB%E7%BB%93/ 中提到

   * Kafka 每个 Partition 都是相互独立的，Kafka 只能保证单个 Partition 下的有序。
    局部有序：当我们所需要的有序其实是针对单个用户的有序，而不要求全局有序。我们可以以用户的 ID 作为 key , 确保单个用户一定会被分配到某个固定的 Partition 上（可能会引起数据倾斜问题），这样我们就能够实现单个用户维度的有序了。
    如果一定要全局的有序，所有消息都使用同一个 key ，这样他们一定会被分配到同一个 Partition 上，这种做法适用于临时性且数据量不大的小需求，消息量大了会有性能压力。


2. 如何保证高效传输的

    1.  发布者每次可发布多条消息（将消息加到一个消息集合中发布）， consumer每次迭代消费一条消息。
    2.  不创建单独的cache，使用系统的page cache。发布者顺序发布，订阅者通常比发布者滞后一点点，直接使用Linux的page cache效果也比较后，同时减少了cache管理及垃圾收集的开销。
    3.  使用sendfile优化网络传输，减少一次内存拷贝。

3. zookeeper 控制

   1. 每个broker启动后会在zookeeper上注册一个临时的broker registry，包含broker的ip地址和端口号，所存储的topics和partitions信息。
   2. 每个consumer启动后会在zookeeper上注册一个临时的consumer registry：包含consumer所属的consumer group以及订阅的topics。
   3. 每个consumer group关联一个临时的owner registry和一个持久的offset registry。对于被订阅的每个partition包含一个owner registry，内容为订阅这个partition的consumer id；同时包含一个offset registry，内容为上一次订阅的offset。

