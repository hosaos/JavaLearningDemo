package bean;

/**
 * @author: chenyin
 * @date: 2019-10-22 13:40
 */
public class ThreadLocalHolder {
    /**
     * 普通THREAD_LOCAL
     */
    private static final ThreadLocal<UserInfo> THREAD_LOCAL = new ThreadLocal<>();

    public static UserInfo getUser() {
        return THREAD_LOCAL.get();
    }

    public static void setUser(UserInfo userInfo) {
        THREAD_LOCAL.set(userInfo);
    }


}
