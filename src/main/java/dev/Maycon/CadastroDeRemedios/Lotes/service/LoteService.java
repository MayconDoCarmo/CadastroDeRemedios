package dev.Maycon.CadastroDeRemedios.Lotes.service;

import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteComRemediosDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteRequestDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteResponseDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.mapper.LoteMapper;
import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Lotes.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoteService {

    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    // Listar todos os lotes (sem remédios)
    public List<LoteResponseDTO> listarLotes() {
        return loteRepository.findAll()
                .stream()
                .map(LoteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Listar todos os lotes com remédios
    public List<LoteComRemediosDTO> listarLotesComRemedios() {
        return loteRepository.findAll()
                .stream()
                .map(LoteMapper::toResponseDetalhadoDTO)
                .collect(Collectors.toList());
    }

    // Buscar lote por ID (simples)
    public LoteResponseDTO buscarLotePorId(Long id) {
        Optional<LoteModel> optional = loteRepository.findById(id);
        return optional.map(LoteMapper::toResponseDTO).orElse(null);
    }

    // Buscar lote por ID com remédios
    public LoteComRemediosDTO buscarLoteComRemedios(Long id) {
        Optional<LoteModel> optional = loteRepository.findById(id);
        return optional.map(LoteMapper::toResponseDetalhadoDTO).orElse(null);
    }

    // Criar lote
    public LoteResponseDTO criarLote(LoteRequestDTO dto) {
        LoteModel novoLote = LoteMapper.toModel(dto);
        return LoteMapper.toResponseDTO(loteRepository.save(novoLote));
    }

    // Atualizar lote
    public LoteResponseDTO atualizarLote(Long id, LoteRequestDTO dto) {
        if (loteRepository.existsById(id)) {
            LoteModel loteAtualizado = LoteMapper.toModel(dto);
            loteAtualizado.setId(id);
            return LoteMapper.toResponseDTO(loteRepository.save(loteAtualizado));
        }
        return null;
    }

    // Deletar lote
    public boolean deletarLote(Long id) {
        if (loteRepository.existsById(id)) {
            loteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}