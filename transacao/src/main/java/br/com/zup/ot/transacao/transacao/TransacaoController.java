package br.com.zup.ot.transacao.transacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public ResponseEntity<?> listaUltimasTransacoes(@RequestParam String numeroCartao,
                                                    @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao){

        List<Optional<EventoDeTransacao>> trasacoesCartao = transacaoRepository.findByCartaoId(numeroCartao);
        if(trasacoesCartao.size()<1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cartão não encontrado ou inválido");
        }
        
        Page ultimasTransacoes = transacaoRepository.findByCartaoId(numeroCartao,paginacao);

        Page<EventoDeTransacaoDTO> ultimosEventosRegistrados = EventoDeTransacaoDTO.fromModel(ultimasTransacoes);
        return ResponseEntity.ok().body(ultimosEventosRegistrados);
    }
}
