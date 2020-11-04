package shenge.netty.gateway;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import shenge.netty.gateway.filter.HeadStrongHttpRequestFilter;
import shenge.netty.gateway.filter.HttpRequestFilter;
import shenge.netty.gateway.router.HttpEndpointRouter;
import shenge.netty.gateway.router.RandomHttpEndpointRouter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/4
 * @time : 5:31 PM
 * @desc : 描述
 */
public class HttpOutboundHandler {

    private static final List<String> backendServerPointList = new ArrayList<String>();

    private HttpEndpointRouter router = new RandomHttpEndpointRouter();

    private HttpRequestFilter filter = new HeadStrongHttpRequestFilter();

    static {
        backendServerPointList.add("8801");
        backendServerPointList.add("8802");
        backendServerPointList.add("8803");
    }

    public HttpResponse handler(ChannelHandlerContext ctx, FullHttpRequest fullRequest) {

        //过滤
        filter.filter(fullRequest, ctx);

        //路由
        String point = router.route(backendServerPointList);

        //访问
        return request(fullRequest, point);
    }

    //访问后端服务
    public HttpResponse request(FullHttpRequest fullRequest, String point) {
        HttpGet httpGet = new HttpGet(String.format("http://localhost:%s/", point));
        fullRequest.headers().entries().forEach(entry -> httpGet.setHeader(entry.getKey(), entry.getValue()));
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

}
