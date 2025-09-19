package OtherFeatures;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class KafkaProducerExample {
	public static void main(String[] args) {
		// Set up properties
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092"); // Kafka broker address
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// Create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		String topic = "my-topic";

		try {
			for (int i = 0; i < 10; i++) {
				String key = "Key" + i;
				String value = "Message " + i;

				// Create producer record
				ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

				// Send data asynchronously
				producer.send(record, (metadata, exception) -> {
					if (exception == null) {
						System.out.printf("Sent message with key=%s to partition=%d offset=%d%n", key,
								metadata.partition(), metadata.offset());
					} else {
						exception.printStackTrace();
					}
				});
			}
		} finally {
			producer.flush(); // Ensure all data is sent
			producer.close(); // Close the producer
		}
	}
}
