package dubbo.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.demo.api.IDemoService;

/**
 * @author: chenyin
 * @date: 2019-10-24 16:03
 */
@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello() {
        return "hthis is dubbo provider";
    }
}
