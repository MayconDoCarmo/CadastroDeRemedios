package dev.Maycon.CadastroDeRemedios.Remedios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/todosID")
    public String mostrarRemedioPorID(){
        return "mostra todos remediosID";
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
