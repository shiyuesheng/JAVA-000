package shenge.netty.gateway.router;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/4
 * @time : 6:28 PM
 * @desc : 描述
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {

    @Override
    public String route(List<String> endpoints) {
        return endpoints.get(RandomUtils.nextInt(0, endpoints.size()));
    }

}
