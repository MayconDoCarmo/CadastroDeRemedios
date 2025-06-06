package dev.Maycon.CadastroDeRemedios.Lotes.controller;

import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteRequestDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.dto.LoteResponseDTO;
import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Lotes.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    // GET - Listar todos os lotes
    @GetMapping("/listar")
    public ResponseEntity<List<LoteResponseDTO>> listarLotes() {
        List<LoteResponseDTO> lotes = loteService.listarLotes();
        return ResponseEntity.ok(lotes);
    }

    // GET - Buscar lote por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<LoteResponseDTO> buscarLotePorId(@PathVariable Long id) {
        LoteResponseDTO lote = loteService.buscarLotePorId(id);
        if (lote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lote);
    }

    // POST - Criar lote
    @PostMapping("/criar")
    public ResponseEntity<LoteResponseDTO> criarLote(@Valid @RequestBody LoteRequestDTO dto) {
        LoteResponseDTO novoLote = loteService.criarLote(dto);
        return ResponseEntity.status(201).body(novoLote);
    }

    // PUT - Atualizar lote
    @PutMapping("alterar/{id}")
    public ResponseEntity<LoteResponseDTO> atualizarLote(@PathVariable Long id, @Valid @RequestBody LoteRequestDTO dto) {
        LoteResponseDTO loteAtualizado = loteService.atualizarLote(id, dto);
        if (loteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loteAtualizado);
    }

    // DELETE - Remover lote
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarLote(@PathVariable Long id) {
        boolean deletado = loteService.deletarLote(id);
        if (!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
