package pl.jarno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.CategoryUsedInTestPattern;



@Repository
public interface CategoryUsedInTestPatternRepository extends JpaRepository<CategoryUsedInTestPattern, Long> {
	List<CategoryUsedInTestPattern> findAllByTestPatternId(Long id);
}
