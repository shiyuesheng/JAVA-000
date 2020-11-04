package shenge.netty.gateway;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.HttpResponse;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderValues.TEXT_PLAIN;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/4
 * @time : 5:31 PM
 * @desc : 描述
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static final String CONTENT = "This is fisrt gateway of shenge！COOL！！！";

    private HttpOutboundHandler outboundHandler = new HttpOutboundHandler();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;

            outboundHandler.handler(ctx, fullRequest);

            response(ctx, fullRequest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void response(ChannelHandlerContext ctx, FullHttpRequest fullRequest) {
        FullHttpResponse response = new DefaultFullHttpResponse(fullRequest.protocolVersion(), OK,
                Unpooled.wrappedBuffer(CONTENT.getBytes()));
        response.headers()
                .set(CONTENT_TYPE, TEXT_PLAIN)
                .setInt(CONTENT_LENGTH, response.content().readableBytes());
        ctx.write(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
