
//import com.platformcommons.platform.service.constant.ServiceConstant;
//import com.platformcommons.platform.service.dto.event.EventDTO;
//import org.apache.kafka.common.protocol.types.Field;
import org.mindtree.platform.service.project.messaging.MessagingConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

@Configuration
@ConditionalOnProperty(name = "igx.platform.messaging.enabled", havingValue = "true")
public class CommonsEventConfiguration {

    @Value("${igx.platform.messaging.servers}")
    private String bootstrapServers;

//    public ConsumerFactory<String, EventDTO> jsonConsumerFactory(String bootstrapServers) {
//        return new DefaultKafkaConsumerFactory<>(
//                EventConfig.jsonConsumerConfig(bootstrapServers));
//    }


    public ConsumerFactory<String, String> stringConsumerFactory(String bootstrapServers) {
        return new DefaultKafkaConsumerFactory<>(
                EventConfig.stringConsumerConfig(bootstrapServers));
    }

//    @Bean(name = ServiceConstant.KAFKA_LISTENER_FACTORY)
//    public ConcurrentKafkaListenerContainerFactory<String, EventDTO> jsonKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, EventDTO> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(jsonConsumerFactory(bootstrapServers));
//        return factory;
//    }


    @Bean(name = MessagingConstants.KAFKA_STRING_LISTENER_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, String> stringKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(stringConsumerFactory(bootstrapServers));
        return factory;
    }

//    public ProducerFactory<String, EventDTO> jsonProducerFactory(String bootstrapServers) {
//        return new DefaultKafkaProducerFactory<>(
//                EventConfig.jsonProducerConfig(bootstrapServers));
//    }

    public ProducerFactory<String, String> stringProducerFactory(String bootstrapServers) {
        return new DefaultKafkaProducerFactory<>(
                EventConfig.stringProducerConfig(bootstrapServers));
    }

//    @Bean("jsonMessageTemplate")
//    public KafkaTemplate<String, EventDTO> jsonMessageTemplate() {
//        return new KafkaTemplate<>(jsonProducerFactory(bootstrapServers));
//    }

    @Bean("stringMessageTemplate")
    public KafkaTemplate<String, String> stringMessageTemplate() {
        return new KafkaTemplate<>(stringProducerFactory(bootstrapServers));
    }
}
