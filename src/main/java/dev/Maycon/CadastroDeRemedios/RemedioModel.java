package dev.Maycon.CadastroDeRemedios;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_cadastro")
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

    private LocalDate dataValidade;
    private String lote;
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
            LocalDate dataValidade,
            String lote,
            String tarja,
            boolean necessitaReceita,
            BigDecimal preco,
            int estoque
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.dosagem = dosagem;
        this.fabricante = fabricante;
        this.dataValidade = dataValidade;
        this.lote = lote;
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
            LocalDate dataValidade,
            String lote,
            String tarja,
            boolean necessitaReceita,
            BigDecimal preco,
            int estoque
    ) {
        this(nome, descricao, dosagem, fabricante, dataValidade, lote, tarja, necessitaReceita, preco, estoque);
        this.formaFarmaceutica = formaFarmaceutica;
        this.principioAtivo = principioAtivo;
        this.ativo = true;
    }


    //Metodos mais essencias para atualizar remedio

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

    //Get
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public String getTarja() {
        return tarja;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public boolean isNecessitaReceita() {
        return necessitaReceita;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}
