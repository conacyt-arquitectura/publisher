package mx.conacyt.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class KafkaCallback implements ListenableFutureCallback<SendResult<String, PersonaFisica>> {
    
    private static final Logger logger = LoggerFactory.getLogger(KafkaCallback.class);


    @Override
    public void onSuccess(SendResult<String, PersonaFisica> result) {
        logger.info("Sent message=[" + result.getProducerRecord().value() + 
        "] with offset=[" + result.getRecordMetadata().offset() + "]");
    }
    @Override
    public void onFailure(Throwable ex) {
        logger.info("Unable to send message=[] due to : " + ex.getMessage());
    }
    
}
