package br.com.squad04.consultoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.squad04.consultoria.model.FeedBack;


@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}

