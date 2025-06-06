package dev.Maycon.CadastroDeRemedios.Remedios.controller;

import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioRequestDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.dto.RemedioResponseDTO;
import dev.Maycon.CadastroDeRemedios.Remedios.model.RemedioModel;
import dev.Maycon.CadastroDeRemedios.Remedios.service.RemedioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    private RemedioService remedioService;

    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return  "Primeira mensagem nessa rota";
    }

    //Adicionar remedios (CREATE)
    @PostMapping("/criar")
    public RemedioResponseDTO criarRemedio(@RequestBody RemedioRequestDTO remedio, LoteModel lote){
        return remedioService.criarRemedio(remedio, lote);
    }

    //Mostrar todos os remedios (READ)
    @GetMapping("/listar")
    public List<RemedioResponseDTO> listarRemedios() {
        return remedioService.listarRemedios();
    }

    //Mostrar remedios por ID (READ)
    @GetMapping("/listar/{id}")
    public RemedioResponseDTO listarRemedioPorId(@PathVariable Long id){
        return remedioService.listarRemedioPorId(id);
    }

    //Alterar dados dos remedios (UPDATE)
    @PutMapping("/alterar/{id}")
    public RemedioResponseDTO alterarRemedioPorId(@PathVariable Long id, @RequestBody RemedioRequestDTO remedioAtualizado, LoteModel lote){
        return remedioService.alterarRemedioPorId(id, remedioAtualizado, lote);
    }

    //Deletar remedios (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarRemedioPorID(@PathVariable Long id) {
        remedioService.deletarRemedioPorID(id);

    }
}
