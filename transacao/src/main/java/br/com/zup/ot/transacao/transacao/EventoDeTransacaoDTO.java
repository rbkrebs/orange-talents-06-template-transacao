package br.com.zup.ot.transacao.transacao;


import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class EventoDeTransacaoDTO {


    private String id;

    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private String efetivadaEm;

    @Deprecated
    EventoDeTransacaoDTO(){}



    public EventoDeTransacaoDTO(String id,
                                BigDecimal valor,
                                Estabelecimento estabelecimento,
                                Cartao cartao,
                                String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public EventoDeTransacaoDTO(EventoDeTransacao eventoDeTransacao) {
        this.id = eventoDeTransacao.getIdTransacao();
        this.valor = eventoDeTransacao.getValor();
        this.estabelecimento = eventoDeTransacao.getEstabelecimento();
        this.cartao = eventoDeTransacao.getCartao();
        this.efetivadaEm = eventoDeTransacao.getEfetivadaEm();
    }


    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<EventoDeTransacaoDTO> fromModel(Page<EventoDeTransacao> ultimasTransacoes) {

        return ultimasTransacoes.map(EventoDeTransacaoDTO::new);

    }



    public EventoDeTransacao toModel() {

        return new EventoDeTransacao(this.id, this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }
}
