package mx.conacyt.publisher;


import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.kafka.support.SendResult;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, PersonaFisica> kafkaTemplate;

    public Optional<RecordMetadata> sendMessage(String topic, PersonaFisica message) {
        logger.info(String.format("-> Productor mensaje : %s", message));
        ListenableFuture<SendResult<String, PersonaFisica>> future = this.kafkaTemplate.send(topic, message);
        try {
            return Optional.of(future.get().getRecordMetadata());
        } catch (InterruptedException | ExecutionException e) {
            return Optional.empty();
        }
    }
}