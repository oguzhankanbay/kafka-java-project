package kafkaproducer.project;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	private WikimediaChangesProducer wikimediaChangesProducer;

	public KafkaProducerApplication(WikimediaChangesProducer wikimediaChangesProducer) {
		this.wikimediaChangesProducer = wikimediaChangesProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}

}
