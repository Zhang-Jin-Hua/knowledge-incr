## 为什么快

#### 底层数据结构不同

> java原生采用的Hash表存储，并且在hash冲突时，采用开放地址法，寻找当前元素的下一个。当发生hash冲突的时候，插入、查找、删除在最坏的情况下，会退化到O(n)
>
> Netty使用数组替换了哈希表，则不存在哈希冲突问题
>
> 数组的地址是连续的，能够有效利用缓存行

#### netty优化了伪共享问题

> 使用long进行填充，使该类独占一个缓存行，避免伪共享问题

```
   public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
       private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    	 private static final int STRING_BUILDER_INITIAL_SIZE;
       private static final int STRING_BUILDER_MAX_SIZE;

       public static final Object UNSET = new Object();

       private BitSet cleanerFlags;
   	   // Cache line padding (must be public)
    	 // With CompressedOops enabled, an instance of this class should occupy at least 128 bytes.
   		 public long rp1, rp2, rp3, rp4, rp5, rp6, rp7, rp8, rp9;
   }

```



