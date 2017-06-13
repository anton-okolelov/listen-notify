package hello.service

import org.springframework.stereotype.Service
import org.springframework.web.socket.handler.BinaryWebSocketHandler

@Service
class WebSocketsHandler: BinaryWebSocketHandler {
    constructor() {

    }

    //fun  afterConnectionEstablished
}