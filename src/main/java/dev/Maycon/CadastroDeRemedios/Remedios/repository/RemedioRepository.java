package dev.Maycon.CadastroDeRemedios.Remedios.repository;

import dev.Maycon.CadastroDeRemedios.Remedios.model.RemedioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<RemedioModel, Long> {
}
