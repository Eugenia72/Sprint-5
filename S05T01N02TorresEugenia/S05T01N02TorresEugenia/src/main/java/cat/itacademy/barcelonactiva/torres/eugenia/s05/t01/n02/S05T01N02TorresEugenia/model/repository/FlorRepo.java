package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.repository;

import cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepo extends JpaRepository<Flor, Integer> {
}

