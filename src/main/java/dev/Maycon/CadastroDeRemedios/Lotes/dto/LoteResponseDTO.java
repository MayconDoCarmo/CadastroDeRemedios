package dev.Maycon.CadastroDeRemedios.Lotes.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class LoteResponseDTO {

    @Setter(AccessLevel.NONE)
    private Long id;

    private String codigo;

    private LocalDate dataDeFabricacao;

    private LocalDate dataDeValidade;
}
