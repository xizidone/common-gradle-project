package tech.tongyu.bct.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.Instant


@AllArgsConstructor
@NoArgsConstructor
class Message(
        val content: String,
        val sent: Instant,
        val username: String,
        val userAvatarImageLink: String
)