package dev.Maycon.CadastroDeRemedios.Remedios;

import dev.Maycon.CadastroDeRemedios.Lotes.LoteModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public RemedioModel criarRemedio(@RequestBody RemedioModel remedio){
        return remedioService.criarRemedio(remedio);
    }

    //Mostrar todos os remedios (READ)
    @GetMapping("/listar")
    public List<RemedioModel> listarRemedios() {
        return remedioService.listarRemedios();
    }

    //Mostrar remedios por ID (READ)
    @GetMapping("/listar/{id}")
    public RemedioModel listarRemedioPorId(@PathVariable Long id){
        return remedioService.listarRemedioPorId(id);
    }

    //Alterar dados dos remedios (UPDATE)
    @PutMapping("/alterar/{id}")
    public RemedioModel alterarRemedioPorID(@PathVariable Long id, @RequestBody RemedioModel remedioAtualizado){
        return remedioService.alterarRemedioPorID(id, remedioAtualizado);
    }

    //Deletar remedios (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarRemedioPorID(@PathVariable Long id) {
        remedioService.deletarRemedioPorID(id);

    }
}
