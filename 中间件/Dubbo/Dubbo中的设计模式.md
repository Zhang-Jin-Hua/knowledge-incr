### 观察者模式

RegistryDirectory实现了NotifyListener接口，用来关注注册中心的信息变更。当变更发生后，注册中心会调用notify接口进行通知。

```
public interface NotifyListener {
    void notify(List<URL> urls);
}
```

```
public class RegistryDirectory<T> extends AbstractDirectory<T> implements NotifyListener {
		// do something
}
```

```
public abstract class AbstractRegistry implements Registry {
		// do something
    protected void notify(URL url, NotifyListener listener, List<URL> urls) {
        // do something
        for (Map.Entry<String, List<URL>> entry : result.entrySet()) {
            // do something
            listener.notify(categoryList);
            // do something
        }
    }
    // do something
}
```

