package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Logger

@Service
class WebSocketsHandler() : TextWebSocketHandler() {

    @Autowired
    lateinit var log: Logger;
    private val sessions: ConcurrentHashMap<String, WebSocketSession> = ConcurrentHashMap<String, WebSocketSession>();

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.put(session.id, session);
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        //super.handleTextMessage(session, message)
        log.info(message.payload);
    }
}