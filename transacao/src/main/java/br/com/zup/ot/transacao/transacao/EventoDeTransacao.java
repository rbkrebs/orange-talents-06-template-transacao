package br.com.zup.ot.transacao.transacao;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class EventoDeTransacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idTransacao;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @Embedded
    private Cartao cartao;
    private String efetivadaEm;

    @Deprecated
    public EventoDeTransacao(){}

    public EventoDeTransacao(String idTransacao,
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

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
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
}
