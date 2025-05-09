package dev.Maycon.CadastroDeRemedios.Remedios.service;

import dev.Maycon.CadastroDeRemedios.Remedios.model.RemedioModel;
import dev.Maycon.CadastroDeRemedios.Remedios.repository.RemedioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    private RemedioRepository remedioRepository;

    public RemedioService( RemedioRepository remedioRepository){
        this.remedioRepository = remedioRepository;
    }


    //Listar todos remedios

    public List<RemedioModel> listarRemedios(){
        return remedioRepository.findAll();
    }

    //Mostrar remedios por ID (READ)

    public RemedioModel listarRemedioPorId(Long id){
        Optional<RemedioModel> remedioPorId = remedioRepository.findById(id);
        return remedioPorId.orElse(null);
    }

    //Criar remedio

    public RemedioModel criarRemedio(RemedioModel remedio){
        return remedioRepository.save(remedio);
    }

    //Alterar remedio

    public RemedioModel alterarRemedioPorID(Long id, RemedioModel remedioAtualizado){
        if(remedioRepository.existsById(id)){
            remedioAtualizado.setId(id);
            return remedioRepository.save(remedioAtualizado);
        }
        return null;
    }


    //Deletar remedio por id

    public void deletarRemedioPorID(Long id){
        remedioRepository.deleteById(id);
    }

}
