package com.oguzhankanbay.kafkaconsumerdatabase;

import com.oguzhankanbay.kafkaconsumerdatabase.entity.WikimediaData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.oguzhankanbay.kafkaconsumerdatabase.repository.KafkaRepository;


@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private KafkaRepository kafkaRepository;

    public KafkaDatabaseConsumer(KafkaRepository kafkaRepository) {
        this.kafkaRepository = kafkaRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        kafkaRepository.save(wikimediaData);
    }
}
