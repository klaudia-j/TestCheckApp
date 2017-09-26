package pl.jarno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
