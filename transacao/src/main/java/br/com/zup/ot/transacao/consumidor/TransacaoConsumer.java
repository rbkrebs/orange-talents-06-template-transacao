package br.com.zup.ot.transacao.consumidor;


import br.com.zup.ot.transacao.transacao.EventoDeTransacao;
import br.com.zup.ot.transacao.transacao.EventoDeTransacaoDTO;
import br.com.zup.ot.transacao.transacao.TransacaoRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class TransacaoConsumer {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "transacaoDTOConcurrentKafkaListenerContainerFactory")
    public void listenerTopicTransacao(ConsumerRecord<String, EventoDeTransacaoDTO> record){

        EventoDeTransacao eventoDeTransacao = record.value().toModel();
        transacaoRepository.save(eventoDeTransacao);

    }
}
