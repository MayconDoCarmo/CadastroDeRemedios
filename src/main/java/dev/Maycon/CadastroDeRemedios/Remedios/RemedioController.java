package dev.Maycon.CadastroDeRemedios.Remedios;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
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
    public String criarRemedio(){
        return "Remedio Criado";
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
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Alterar Ninja por id";
    }

    //Deletar remedios (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarRemedioPorID(){
        return "deletar remedio por id";
    }
}
