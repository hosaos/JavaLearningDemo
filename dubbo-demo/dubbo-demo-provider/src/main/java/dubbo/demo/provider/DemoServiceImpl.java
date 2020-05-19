package dubbo.demo.provider;

import dubbo.demo.api.IDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyin
 * @date: 2019-10-24 16:03
 */
@Service(version = "${dubbo.service.version}",timeout = 3000)
public class DemoServiceImpl implements IDemoService {
    static Integer count = 0;
    @Override
    public String sayHello() {
        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getIp();
    }

    @Override
    public String read(Long userId) {
        String ip = getIp();
        return "read:" + ip;
    }

    @Override
    public String write(Long userId) {
        String ip = getIp();
        return "write:" + ip;
    }

    private String getIp() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
