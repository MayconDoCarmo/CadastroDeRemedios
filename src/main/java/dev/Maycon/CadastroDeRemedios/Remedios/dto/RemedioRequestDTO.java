package dev.Maycon.CadastroDeRemedios.Remedios.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemedioRequestDTO {

    private String nome;
    private String descricao;
    private String dosagem;

    private String formaFarmaceutica;

    private String principioAtivo;
    private String fabricante;

    private Long loteId;
    private String tarja;
    private boolean necessitaReceita;

    private BigDecimal preco;
    private int estoque;
    private boolean ativo;

}
