package br.com.zup.ot.transacao.transacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EventoDeTransacaoDTO {

    @JsonProperty
    private String idTransacao;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private Estabelecimento estabelecimento;
    @JsonProperty
    private Cartao cartao;
    @JsonProperty
    private String efetivadaEm;

    @JsonCreator
    public EventoDeTransacaoDTO(String idTransacao,
                                BigDecimal valor,
                                Estabelecimento estabelecimento,
                                Cartao cartao,
                                String efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

}
