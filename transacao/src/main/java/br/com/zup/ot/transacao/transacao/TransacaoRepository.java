package br.com.zup.ot.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<EventoDeTransacao, Long> {

    List<Optional<EventoDeTransacao>> findByCartaoId(String numeroCartao);

    Page<EventoDeTransacao> findByCartaoId(String numeroCartao, Pageable pageable);
}
