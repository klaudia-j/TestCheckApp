package pl.jarno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.TestPattern;


@Repository
public interface TestPatternRepository extends JpaRepository<TestPattern, Long> {

}
