package dubbo.demo.spi.dubbo;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author: chenyin
 * @date: 2019-10-26 10:27
 */
@SPI
public interface ISpiDemoService {
    void sayHello();
}
