Q: String为什么不可变

A: 1. 实现保证，内部属性设置为final，保证初始化之后就不能改变 2. 提供给外部的api不能直接操作内部属性，并且涉及到修改的部分，都是重新创建String对象 3.class声明为final，进一步保证不能够通过继承来修改内部值 4. JVM对String对象的优化，参考字符串常量池 5. 事实上，可以通过反射修改String对象的值

参考

https://www.zhihu.com/question/20618891

https://blog.csdn.net/yuqi007163/article/details/53559864

https://segmentfault.com/a/1190000009888357

----
Q: String/StringBuffer/StringBuilder的区别

A:
String是不可变对象，一旦初始化就不能改变。而StringBuffer和StringBuilder均为可变对象。String因为它的不可变性天然线程安全，而StringBuffer内部使用synchronized来保证它是线程安全的，StringBuilder是非123线程安全的。

|               | 性能  |  线程安全  |  可变   |
| --------      |   :----:   | :----:    |:----:    |
| String        | 快    |   是      |  不可变 |
| StringBuilder | 超快  |   否      |  可变   |
| StringBuffer  | 慢    |  是       |  可变  |

StringBuffer和StringBuilder均继承自AbstractStringBuilder，AbstractStringBuilder实现了各类append方法。StringBuffer的线程安全通过sychronized实现，均加在了方法签名上。

```
    @Override
    public synchronized StringBuffer append(CharSequence s) {
        toStringCache = null;
        super.append(s);
        return this;
    }

    /**
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @since      1.5
     */
    @Override
    public synchronized StringBuffer append(CharSequence s, int start, int end)
    {
        toStringCache = null;
        super.append(s, start, end);
        return this;
    }
```

