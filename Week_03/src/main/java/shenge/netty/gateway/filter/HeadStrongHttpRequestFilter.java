package shenge.netty.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/4
 * @time : 7:05 PM
 * @desc : 描述
 */
public class HeadStrongHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio", "shiyuesheng");
    }
}
