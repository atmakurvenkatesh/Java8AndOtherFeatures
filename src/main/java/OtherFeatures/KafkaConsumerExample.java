package OtherFeatures;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {
	public static void main(String[] args) {
		// Set up properties
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092"); // Kafka broker address
		props.put("group.id", "my-group"); // Consumer group ID
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
		props.put("auto.offset.reset", "earliest"); // Read from the beginning

		// Create the consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

		// Subscribe to topic
		consumer.subscribe(Collections.singletonList("my-topic"));

		// Poll messages
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

				for (ConsumerRecord<String, String> record : records) {
					System.out.printf("Received message: key=%s, value=%s, partition=%d, offset=%d%n", record.key(),
							record.value(), record.partition(), record.offset());
				}
			}
		} finally {
			consumer.close(); // Close the consumer gracefully
		}
	}
}
