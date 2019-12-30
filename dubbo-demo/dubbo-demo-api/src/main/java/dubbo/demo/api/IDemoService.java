package dubbo.demo.api;

/**
 * @author: chenyin
 * @date: 2019-10-24 15:52
 */
public interface IDemoService {
    String sayHello();

    //读取方法
    String read(Long userId);
    //写方法
    String write(Long userId);

}
