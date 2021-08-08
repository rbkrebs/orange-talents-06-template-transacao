package br.com.zup.ot.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<EventoDeTransacao, Long> {
}
