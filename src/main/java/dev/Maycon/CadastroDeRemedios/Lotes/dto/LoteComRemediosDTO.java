package dev.Maycon.CadastroDeRemedios.Lotes.dto;

import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioResponseDTO;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class LoteComRemediosDTO {

    private Long id;
    private String codigo;
    private LocalDate dataDeFabricacao;
    private LocalDate dataDeValidade;
    private List<RemedioResponseDTO> remedios;

}
