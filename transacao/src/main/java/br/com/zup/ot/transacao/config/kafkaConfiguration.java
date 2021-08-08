package br.com.zup.ot.transacao.config;

import br.com.zup.ot.transacao.transacao.EventoDeTransacaoDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConfiguration {


    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value(value = "${spring.kafka.consumer.key-deserializer}")
    private String keyDeserializer;

    @Value(value = "${spring.kafka.consumer.value-deserializer}")
    private String valueDeserializer;

    @Bean
    public ConsumerFactory<String, EventoDeTransacaoDTO> consumerConfigurations() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, this.keyDeserializer);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, this.valueDeserializer);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, this.groupId);

        return new DefaultKafkaConsumerFactory(properties, new StringDeserializer(), new JsonDeserializer<>(EventoDeTransacaoDTO.class, false));
    }

   @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacaoDTO> transacaoDTOConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacaoDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerConfigurations());
        return factory;
   }
}
