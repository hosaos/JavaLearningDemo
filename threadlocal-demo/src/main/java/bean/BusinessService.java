package bean;

/**
 * 模拟业务处理类
 *
 * @author: chenyin
 * @date: 2019-10-22 13:56
 */
public class BusinessService {
    /**
     * 模拟同步处理业务
     */
    public void doBusiness() {
        //获取用户信息，避免显示参数传递
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalHolder.getUser());
        //业务处理。。略去
    }
    /**
     * 模拟异步处理业务
     */
    public void doBusinessAsync() {
        new Thread(() -> {
            //获取用户信息，避免显示参数传递
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalHolder.getUser());
            //业务处理。。略去
        }).start();

    }

}
