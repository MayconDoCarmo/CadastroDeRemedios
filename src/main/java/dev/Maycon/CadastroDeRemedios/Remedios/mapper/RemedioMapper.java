package dev.Maycon.CadastroDeRemedios.Remedios.mapper;

import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioRequestDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioResponseDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.model.RemedioModel;

public class RemedioMapper {

    public RemedioModel map(RemedioRequestDTO requestDTO, LoteModel lote){
        RemedioModel remedioModel = new RemedioModel();
        remedioModel.setNome(requestDTO.getNome());
        remedioModel.setDescricao(requestDTO.getDescricao());
        remedioModel.setDosagem(requestDTO.getDosagem());
        remedioModel.setFormaFarmaceutica(requestDTO.getFormaFarmaceutica());
        remedioModel.setPrincipioAtivo(requestDTO.getPrincipioAtivo());
        remedioModel.setFabricante(requestDTO.getFabricante());
        remedioModel.setLote(lote);
        remedioModel.setTarja(requestDTO.getTarja());
        remedioModel.setNecessitaReceita(requestDTO.isNecessitaReceita());
        remedioModel.setPreco(requestDTO.getPreco());
        remedioModel.setEstoque(requestDTO.getEstoque());
        remedioModel.setAtivo(requestDTO.isAtivo());
        return remedioModel;

    };

    public RemedioResponseDTO map(RemedioModel remedioModel){
        RemedioResponseDTO responseDTO = new RemedioResponseDTO();
        responseDTO.setId(remedioModel.getId());
        responseDTO.setNome(remedioModel.getNome());
        responseDTO.setDescricao(remedioModel.getDescricao());
        responseDTO.setDosagem(remedioModel.getDosagem());
        responseDTO.setFormaFarmaceutica(remedioModel.getFormaFarmaceutica());
        responseDTO.setPrincipioAtivo(remedioModel.getPrincipioAtivo());
        responseDTO.setFabricante(remedioModel.getFabricante());
        responseDTO.setTarja(remedioModel.getTarja());
        responseDTO.setNecessitaReceita(remedioModel.isNecessitaReceita());
        responseDTO.setPreco(remedioModel.getPreco());
        responseDTO.setEstoque(remedioModel.getEstoque());
        responseDTO.setAtivo(remedioModel.isAtivo());
        responseDTO.setCriadoEm(remedioModel.getCriadoEm());
        responseDTO.setAtualizadoEm(remedioModel.getAtualizadoEm());
        responseDTO.setUltimaConsulta(remedioModel.getUltimaConsulta());

        return responseDTO;
    }


}
