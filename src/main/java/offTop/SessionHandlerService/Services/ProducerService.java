package offTop.SessionHandlerService.Services;

import offTop.SessionHandlerService.Models.IncomingAudioEvent;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "IncomingAudioEvent";

    //@Autowired
    private KafkaTemplate<String, IncomingAudioEvent> kafkaTemplate;

    // produces and sends message by topic
    public void sendMessage(String message) {
        logger.info(String.format(" Producing message -> %s", message));
        // kafkaTemplate.send(TOPIC, message);
    }
    public void sendAudioFile(IncomingAudioEvent incomingAudioEvent) {
        kafkaTemplate.send(TOPIC, incomingAudioEvent);
        logger.info(String.format(" Producing message -> %s", incomingAudioEvent));
    }

}