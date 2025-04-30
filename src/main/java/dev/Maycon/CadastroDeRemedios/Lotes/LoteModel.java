package dev.Maycon.CadastroDeRemedios.Lotes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Maycon.CadastroDeRemedios.Remedios.RemedioModel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Entity
@Table(name = "tb_lotes")
@Getter
@Setter
@NoArgsConstructor
public class LoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter
    private String codigo;

    @Setter
    private LocalDate dataDeFabricaco;

    @Setter
    private LocalDate dataDeValidade;


    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RemedioModel> remedios = new ArrayList<>();


    public LoteModel(String codigo,
                     LocalDate dataDeFabricacao,
                     LocalDate dataDeValidade
    ) {
        this.codigo = codigo;
        this.dataDeFabricaco = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
    }
}

