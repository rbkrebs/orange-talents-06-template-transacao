package br.com.zup.ot.transacao.consumidor;


import br.com.zup.ot.transacao.transacao.EventoDeTransacaoDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {




    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "transacaoDTOConcurrentKafkaListenerContainerFactory")
    public void listenerTopicTransacao(ConsumerRecord<String, EventoDeTransacaoDTO> record){
        System.out.println(record.value());
    }
}
