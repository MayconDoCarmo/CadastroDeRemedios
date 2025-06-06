package dev.Maycon.CadastroDeRemedios.Remedios.service;

import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioRequestDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioResponseDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.mapper.RemedioMapper;
import dev.Maycon.CadastroDeRemedios.Remedios.model.RemedioModel;
import dev.Maycon.CadastroDeRemedios.Remedios.repository.RemedioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RemedioService {

    private final RemedioRepository remedioRepository;

    public RemedioService(RemedioRepository remedioRepository) {
        this.remedioRepository = remedioRepository;
    }

    // Listar todos os remédios
    public List<RemedioResponseDTO> listarRemedios() {
        return remedioRepository.findAll()
                .stream()
                .map(RemedioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Mostrar remédio por ID
    public RemedioResponseDTO listarRemedioPorId(Long id) {
        Optional<RemedioModel> remedioOptional = remedioRepository.findById(id);
        return remedioOptional.map(RemedioMapper::toResponseDTO).orElse(null);
    }

    // Criar remédio
    public RemedioResponseDTO criarRemedio(RemedioRequestDTO dto, LoteModel lote) {
        RemedioModel novoRemedio = new RemedioMapper().toRequestDTO(dto, lote);
        return RemedioMapper.toResponseDTO(remedioRepository.save(novoRemedio));
    }

    // Atualizar remédio
    public RemedioResponseDTO alterarRemedioPorId(Long id, RemedioRequestDTO dto, LoteModel lote) {
        if (remedioRepository.existsById(id)) {
            RemedioModel remedioAtualizado = new RemedioMapper().toRequestDTO(dto, lote);
            remedioAtualizado.setId(id);
            return RemedioMapper.toResponseDTO(remedioRepository.save(remedioAtualizado));
        }
        return null;
    }

    // Deletar remédio
    public void deletarRemedioPorID(Long id) {
        remedioRepository.deleteById(id);
    }
}