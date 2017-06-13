package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ListenNotifyApplication

fun main(args: Array<String>) {
    SpringApplication.run(ListenNotifyApplication::class.java, *args)
}
