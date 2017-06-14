package hello
Бывает выгоднее чем json
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap
import org.json.JSONObject
import javax.sql.DataSource

@Service
class WebSocketsHandler : TextWebSocketHandler() {

    @Autowired
    var dataSource: DataSource? = null

    private val logger:Logger = LoggerFactory.getLogger(this.javaClass)
    private val sessions = ConcurrentHashMap<String, WebSocketSession>();

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.put(session.id, session);
        val conn = dataSource!!.getConnection()
        val stmt = conn.createStatement()
        val sql = "SELECT count(*) FROM all_tables"
        val rs = stmt.executeQuery(sql);

    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        //super.handleTextMessage(session, message)
        logger.debug(message.payload);
        val answer = JSONObject(message.payload);
        val newBid = answer.getDouble("newBid");
        logger.debug("{}", newBid);
    }
}