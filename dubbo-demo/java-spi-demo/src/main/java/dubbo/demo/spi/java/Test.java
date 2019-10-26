package dubbo.demo.spi.java;

import java.util.ServiceLoader;

/**
 * @author: chenyin
 * @date: 2019-10-26 10:36
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<ISpiDemoService> serviceLoader = ServiceLoader.load(ISpiDemoService.class);

        serviceLoader.forEach(ISpiDemoService::sayHello);
    }
}
