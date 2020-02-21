package gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.core.io.buffer.DataBuffer;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;

public class TokenFilter  implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String token = exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpResponse response = exchange.getResponse();
        if(token==null|| token.isEmpty()){
            JSONObject message = new JSONObject();
            message.put("status", -1);
            message.put("data", "鉴权失败");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            logger.error("token is empty");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
