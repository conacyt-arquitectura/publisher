package mx.conacyt.publisher;

import java.time.Instant;
import java.util.Optional;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish/{topic}")
    public PublishResult sendMessageToKafkaTopic(@PathVariable String topic, @RequestBody PersonaFisica message) {
        Optional<RecordMetadata> optional = this.producer.sendMessage(topic, message);

        if (optional.isPresent()) {
            return new PublishResult(optional.get());
        } else {
            return new PublishResult();
        }

    }
}