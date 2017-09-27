package pl.jarno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	List<Question> findByCategoryId(Long id);
	int countByCategoryId(Long id);
	

}
