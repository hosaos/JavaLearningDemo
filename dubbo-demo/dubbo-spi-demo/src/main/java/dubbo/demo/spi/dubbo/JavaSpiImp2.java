package dubbo.demo.spi.dubbo;

/**
 * @author: chenyin
 * @date: 2019-10-26 10:34
 */
public class JavaSpiImp2 implements ISpiDemoService {
    @Override
    public void sayHello() {
        System.out.println("java spi implemention 222");
    }
}
