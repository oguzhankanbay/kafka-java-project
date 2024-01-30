package com.oguzhankanbay.kafkaconsumerdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Getter
@Setter
@Data
@Document(collection = "wikimedia_recentchange")
public class WikimediaData {
    @Id
    private String id;

    @Lob
    private String wikiEventData;

}
