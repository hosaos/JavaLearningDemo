package dubbo.demo.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author: chenyin
 * @date: 2019-10-26 11:15
 */
public class Test {
    public static void main(String[] args) {
        ExtensionLoader<ISpiDemoService> extensionLoader =
                ExtensionLoader.getExtensionLoader(ISpiDemoService.class);

        ISpiDemoService spiDemoService1 = extensionLoader.getExtension("spiImpl1");
        spiDemoService1.sayHello();
        ISpiDemoService spiDemoService2 = extensionLoader.getExtension("spiImpl2");
        spiDemoService2.sayHello();

    }
}
