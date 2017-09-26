package pl.jarno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.Answer;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
