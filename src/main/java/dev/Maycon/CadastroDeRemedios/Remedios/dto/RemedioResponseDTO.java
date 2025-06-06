package dev.Maycon.CadastroDeRemedios.Remedios.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemedioResponseDTO {
    private Long id;

    private String nome;
    private String descricao;
    private String dosagem;

    private String formaFarmaceutica;

    private String principioAtivo;
    private String fabricante;

    private String tarja;
    private boolean necessitaReceita;

    private BigDecimal preco;
    private int estoque;
    private boolean ativo;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private LocalDateTime ultimaConsulta;

}
