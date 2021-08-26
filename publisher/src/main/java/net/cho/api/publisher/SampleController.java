package net.cho.api.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SampleController {
    private static final String EXCHANGE_NAME = "sample.exchange";
    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/sample/queue")
    public String samplePublish(){
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,"sample.key.#","RabbitMQ success");
        return "message sending";
    }

}
