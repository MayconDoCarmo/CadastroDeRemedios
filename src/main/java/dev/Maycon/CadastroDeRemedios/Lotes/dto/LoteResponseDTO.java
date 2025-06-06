package dev.Maycon.CadastroDeRemedios.Lotes.dto;
import lombok.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class LoteResponseDTO {

    private Long id;

    private String codigo;

    private LocalDate dataDeFabricacao;

    private LocalDate dataDeValidade;
}
