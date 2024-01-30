package com.oguzhankanbay.kafkaconsumerdatabase.repository;

import com.oguzhankanbay.kafkaconsumerdatabase.entity.WikimediaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepository extends MongoRepository<WikimediaData, String> {
}
