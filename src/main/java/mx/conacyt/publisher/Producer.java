package mx.conacyt.publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, PersonaFisica> kafkaTemplate;

    public void sendMessage(String topic, PersonaFisica message) {
        logger.info(String.format("-> Productor mensaje : %s", message));
        this.kafkaTemplate.send(topic, message);
    }
}