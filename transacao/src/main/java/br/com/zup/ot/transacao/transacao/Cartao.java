package br.com.zup.ot.transacao.transacao;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cartao {

    @Column(name = "id_cartao")
    private String id;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {

        this.id = id;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }


}
