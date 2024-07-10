package br.com.squad04.consultoria.repository;

import br.com.squad04.consultoria.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {
}
