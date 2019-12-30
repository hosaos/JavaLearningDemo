package dubbo.demo.provider;

import dubbo.demo.api.IDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: chenyin
 * @date: 2019-10-24 16:03
 */
@Service(version = "${dubbo.service.version}")
public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello() {
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
