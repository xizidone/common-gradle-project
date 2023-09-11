package tech.tongyu.bct.controller


import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.tongyu.bct.pojo.Message
import java.time.Instant

@RestController
@RequestMapping("/kotlin")
class HtmlController() {


    @GetMapping("/t01")
    fun index(model: Model): String {
        val messages = Message("1", Instant.now(), "test", "zxcv");

        return messages.content;
    }
}