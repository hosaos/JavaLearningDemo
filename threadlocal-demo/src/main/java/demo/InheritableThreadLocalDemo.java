package demo;

import bean.LoginInterceptor;
import bean.UserInfo;

/**
 * @author: chenyin
 * @date: 2019-10-22 13:13
 */
public class InheritableThreadLocalDemo {

    private static final InheritableThreadLocal<UserInfo> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        //模拟一个普通的异步web请求
        new Thread(() -> {
            UserInfo userInfo = loginInterceptor.getUserFromRedis();
            // 模拟用户身份拦截器
            INHERITABLE_THREAD_LOCAL.set(userInfo);
            System.out.println(Thread.currentThread().getName() + ":" + INHERITABLE_THREAD_LOCAL.get());
            new Thread(() -> {
                //获取用户信息，避免显示参数传递
                System.out.println(Thread.currentThread().getName() + ":" + INHERITABLE_THREAD_LOCAL.get());
                //业务处理。。略去
            }).start();
        }).start();
    }
}
