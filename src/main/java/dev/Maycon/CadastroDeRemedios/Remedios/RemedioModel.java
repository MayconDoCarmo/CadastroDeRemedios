package dev.Maycon.CadastroDeRemedios.Remedios;
import dev.Maycon.CadastroDeRemedios.Lotes.LoteModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cadastro")
@Getter
@Setter
public class RemedioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String dosagem;
    private String formaFarmaceutica;
    private String principioAtivo;
    private String fabricante;


    @ManyToOne
    @JoinColumn(name = "lote_id", nullable = false)

    private LoteModel lote;
    private String tarja;
    private boolean necessitaReceita;

    private BigDecimal preco;
    private int estoque;
    private boolean ativo;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;


    @PrePersist
    protected void onCreate(){
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }


    @PreUpdate
    protected void onUpdate(){
        this.atualizadoEm = LocalDateTime.now();
    }

    protected RemedioModel() {
    }

    public RemedioModel(
            String nome,
            String descricao,
            String dosagem,
            String fabricante,
            LoteModel lote,
            String tarja,
            boolean necessitaReceita,
            BigDecimal preco,
            int estoque
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.dosagem = dosagem;
        this.fabricante = fabricante;
        this.setLote(lote);
        this.tarja = tarja;
        this.necessitaReceita = necessitaReceita;
        this.preco = preco;
        this.estoque = estoque;
        this.ativo = true;
    }

    public RemedioModel(
            String nome,
            String descricao,
            String dosagem,
            String formaFarmaceutica,
            String principioAtivo,
            String fabricante,
            LoteModel lote,
            String tarja,
            boolean necessitaReceita,
            BigDecimal preco,
            int estoque
    ) {
        this(nome, descricao, dosagem, fabricante, lote, tarja, necessitaReceita, preco, estoque);
        this.formaFarmaceutica = formaFarmaceutica;
        this.principioAtivo = principioAtivo;
        this.ativo = true;
    }


    //Metodos mais essencias para atualizar remediogit

    public void atualizarNome(String novoNome){
        if (novoNome == null || novoNome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome do remédio não pode estar vazio.");
        }
        this.nome = novoNome.trim();
    }

    public void atualizarPreco(BigDecimal novoPreco){
        if (novoPreco == null || novoPreco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.preco = novoPreco;
    }

    public void atualizarEstoque(int novoEstoque){
        if (novoEstoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = novoEstoque;
    }

    public void atualizarTarja(String novaTarja){
        if (novaTarja == null || novaTarja.trim().isEmpty()) {
            throw new IllegalArgumentException("A Tarja não pode estar vazia");
        }
        this.tarja = novaTarja.trim();
    }

    public void atualizarFormaFarmaceutica(String novaForma) {
        this.formaFarmaceutica = novaForma;
    }

    public void atualizarDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    public void atualizarDosagem(String novaDosagem){
        this.dosagem = novaDosagem;
    }

    public void atualizarPrincipioAtivo(String novoPrincipio){
        this.principioAtivo = novoPrincipio;
    }

    public void ativar(){
        this.ativo = true;
    }

    public void desativar(){
        this.ativo = false;
    }

    public void setLote(LoteModel lote) {
        if (lote == null) {
            throw new IllegalArgumentException("O lote não pode ser nulo.");
        }
        this.lote = lote;
    }

    //Get
    public LocalDate getDataValidade() {
        if (lote == null) {
            throw new IllegalStateException("Lote ainda não foi atribuído a este remédio.");
        }
        return lote.getDataDeValidade();

    }

}
