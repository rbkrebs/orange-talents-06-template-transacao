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
}
