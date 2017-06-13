package hello


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry


@Configuration
@EnableWebSocket
@Service
class WebSocketConfig: WebSocketConfigurer {

    var webSocketsHandler: WebSocketsHandler;

    @Autowired
    constructor(webSocketsHandler: WebSocketsHandler) {
        this.webSocketsHandler = webSocketsHandler;
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry?) {
        registry?.addHandler(this.webSocketsHandler, "/ws")?.setAllowedOrigins("*");
    }

}