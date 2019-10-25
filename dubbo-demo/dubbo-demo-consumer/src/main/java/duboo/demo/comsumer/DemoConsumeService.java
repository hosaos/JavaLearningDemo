package duboo.demo.comsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import dubbo.demo.api.IDemoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: chenyin
 * @date: 2019-10-25 10:38
 */
@Component
public class DemoConsumeService implements InitializingBean {
    @Reference
    private IDemoService demoService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(demoService.sayHello());
    }
}
