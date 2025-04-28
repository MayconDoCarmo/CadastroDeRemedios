package dev.Maycon.CadastroDeRemedios.Remedios;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
