package dev.Maycon.CadastroDeRemedios.Lotes.mapper;

import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteComRemediosDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteRequestDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteResponseDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Remedios.mapper.RemedioMapper;

import java.util.stream.Collectors;

public class LoteMapper {

    public static LoteModel toModel(LoteRequestDTO loteRequestDTO){
        LoteModel loteModel = new LoteModel();
        loteModel.setCodigo(loteRequestDTO.getCodigo());
        loteModel.setDataDeValidade(loteRequestDTO.getDataDeValidade());
        loteModel.setDataDeFabricacao(loteRequestDTO.getDataDeFabricacao());
        return loteModel;
    }

    public static LoteResponseDTO toResponseDTO(LoteModel lote){
        LoteResponseDTO loteResponseDTO = new LoteResponseDTO();
        loteResponseDTO.setId(lote.getId());
        loteResponseDTO.setCodigo(lote.getCodigo());
        loteResponseDTO.setDataDeValidade(lote.getDataDeValidade());
        loteResponseDTO.setDataDeFabricacao(lote.getDataDeFabricacao());
        return loteResponseDTO;
    }

    public static LoteComRemediosDTO toResponseDetalhadoDTO(LoteModel lote) {
        LoteComRemediosDTO loteComRemediosDTO = new LoteComRemediosDTO();
        loteComRemediosDTO.setId(lote.getId());
        loteComRemediosDTO.setCodigo(lote.getCodigo());
        loteComRemediosDTO.setDataDeValidade(lote.getDataDeValidade());
        loteComRemediosDTO.setDataDeFabricacao(lote.getDataDeFabricacao());
        loteComRemediosDTO.setRemedios(lote.getRemedios()
                .stream()
                .map(RemedioMapper::toResponseDTO)
                .collect(Collectors.toList()));
        return loteComRemediosDTO;
    }
}
