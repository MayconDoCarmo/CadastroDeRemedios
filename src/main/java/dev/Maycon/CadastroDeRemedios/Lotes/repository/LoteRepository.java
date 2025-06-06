package dev.Maycon.CadastroDeRemedios.Lotes.repository;

import dev.Maycon.CadastroDeRemedios.Lotes.model.LoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<LoteModel, Long> {
}
