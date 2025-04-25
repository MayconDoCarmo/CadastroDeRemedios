package dev.Maycon.CadastroDeRemedios.Lotes;

import dev.Maycon.CadastroDeRemedios.Remedios.RemedioModel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_lotes")
public class LoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private LocalDate dataDeFabricaco;
    private LocalDate dataDeValidade;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RemedioModel> remedios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataDeFabricaco() {
        return dataDeFabricaco;
    }

    public void setDataDeFabricaco(LocalDate dataDeFabricaco) {
        this.dataDeFabricaco = dataDeFabricaco;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }
}

